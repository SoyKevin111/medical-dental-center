package com.example.project.patient.application.usecase;

import com.example.project.patient.domain.RequestPatient;
import com.example.project.patient.domain.IPatientUseCase;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.infraestructure.persistence.PatientRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientUseCase implements IPatientUseCase {

   @Autowired
   PatientRepositoryMySql patientRepositoryMySql;

   @Override
   public Patient save(Patient patient) {
      return this.patientRepositoryMySql.save(patient);
   }

   @Override
   public Optional<Patient> update(RequestPatient requestPatient, Long id) {

      Optional<Patient> optionalPatient = this.patientRepositoryMySql.findById(id);
      if(optionalPatient.isPresent()){
         Patient patientDB = optionalPatient.get();
         patientDB.setName(requestPatient.name());
         patientDB.setSurname(requestPatient.surname());
         patientDB.setAge(requestPatient.age());

         return Optional.of(this.patientRepositoryMySql.save(patientDB));
      }
      return Optional.empty();
   }

   @Override
   public void delete(Long id) {
      this.patientRepositoryMySql.deleteById(id);
   }

   @Override
   public Optional<Patient> findById(Long id) {
      return  this.patientRepositoryMySql.findById(id);
   }

   @Override
   public List<Patient> findAll() {
      return (List) this.patientRepositoryMySql.findAll();
   }

   @Override
   public boolean existsByIdentification(String identification) {
      return this.patientRepositoryMySql.existsByIdentification(identification);
   }
}
