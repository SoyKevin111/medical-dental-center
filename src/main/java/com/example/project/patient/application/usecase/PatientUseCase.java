package com.example.project.patient.application.usecase;

import com.example.project.patient.domain.CreatePatient;
import com.example.project.patient.domain.IPatientUseCase;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.exception.PatientValidationException;
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
      return null;
   }

   @Override
   public Optional<Patient> update(CreatePatient createPatient, Long id) {

      Optional<Patient> optionalPatient = this.patientRepositoryMySql.findById(id);
      if(optionalPatient.isPresent()){
         Patient patientDB = optionalPatient.get();
         patientDB.setName(createPatient.name());
         patientDB.setSurname(createPatient.surname());
         patientDB.setAge(createPatient.age());

         return Optional.of(this.patientRepositoryMySql.save(patientDB));
      }
      return Optional.empty();
   }

   @Override
   public void delete(Long id) {

   }

   @Override
   public Optional<Patient> findById(Long id) {
      return Optional.empty();
   }

   @Override
   public List<Patient> findAll() {
      return List.of();
   }

   @Override
   public boolean existsByIdentification(String identification) {
      return false;
   }
}
