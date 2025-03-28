package com.example.project.patient.infraestructure.adapter.out.persistence;

import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.port.out.IPatientRepository;
import com.example.project.patient.infraestructure.adapter.out.persistence.mysql.PatientRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepositoryImpl implements IPatientRepository {

   @Autowired
   PatientRepositoryMySql patientRepositoryMySql;

   @Override
   public Patient save(Patient patient) {
      return this.patientRepositoryMySql.save(patient);
   }

   @Override
   public Patient update(Patient patient) {
      return this.patientRepositoryMySql.save(patient);
   }

   @Override
   public void delete(Long id) {
      this.patientRepositoryMySql.deleteById(id);
   }

   @Override
   public Optional<Patient> findById(Long id) {
      return this.patientRepositoryMySql.findById(id);
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
