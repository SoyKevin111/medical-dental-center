package com.example.project.patient.application.usecase;

import com.example.project.patient.domain.RequestPatient;
import com.example.project.patient.domain.exception.PatientValidationException;
import com.example.project.patient.domain.port.in.IPatientUseCase;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.port.out.IPatientRepository;
import com.example.project.patient.domain.validation.PatientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientUseCase implements IPatientUseCase {

   @Autowired
   IPatientRepository patientRepository;

   @Autowired
   PatientValidator patientValidator;

   @Override
   public Patient save(Patient patient) {
      List<String> errors = this.patientValidator.validatePatientData(patient);
      if(!errors.isEmpty()){
         throw new PatientValidationException(errors);
      } //validaciones de dominio

      if(patientRepository.existsByIdentification(patient.getIdentification())){ //validaciones en la base de datos.
         throw new PatientValidationException(List.of("Error de creacion, paciente existente."));
      }
      return this.patientRepository.save(patient);
   }

   @Override
   public Optional<Patient> update(RequestPatient requestPatient, Long id) {
      List<String> errors = this.patientValidator.validateRequestPatientData(requestPatient.age(), requestPatient.name(), requestPatient.surname());
      if(!errors.isEmpty()){
         throw new PatientValidationException(errors);
      } //validaciones de dominio

      Optional<Patient> optionalPatient = this.patientRepository.findById(id);
      if(optionalPatient.isPresent()){
         Patient patientDB = optionalPatient.get();
         patientDB.setName(requestPatient.name());
         patientDB.setSurname(requestPatient.surname());
         patientDB.setAge(requestPatient.age());

         return Optional.of(this.patientRepository.update(patientDB));
      }//validaciones de base datos
      return Optional.empty();
   }

   @Override
   public void delete(Long id) {
      Optional<Patient> optionalPatient = this.patientRepository.findById(id);
      if(optionalPatient.isEmpty()){
         throw new PatientValidationException(List.of("Error de busqueda, no se encontro el paciente para eliminar."));
      }
      this.patientRepository.delete(id); //yes
   }

   @Override
   public Optional<Patient> findById(Long id) {
      Optional<Patient> optionalPatient = this.patientRepository.findById(id);
      if(optionalPatient.isEmpty()){
         throw new PatientValidationException(List.of("Error de busqueda, no se encontro el paciente."));
      }
      return  optionalPatient;
   }

   @SuppressWarnings({"rawtypes","unchecked"})
   @Override
   public List<Patient> findAll() {
      return (List) this.patientRepository.findAll();
   }

   @Override
   public boolean existsByIdentification(String identification) {
      return this.patientRepository.existsByIdentification(identification);
   }
}
