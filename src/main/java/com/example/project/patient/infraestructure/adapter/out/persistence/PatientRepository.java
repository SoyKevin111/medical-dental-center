package com.example.project.patient.infraestructure.adapter.out.persistence;

import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.port.out.IPatientRepository;
import com.example.project.patient.infraestructure.adapter.out.persistence.database.PatientRepositorySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientRepository implements IPatientRepository {

   @Autowired
   PatientRepositorySql patientRepository;

   @Override
   public Patient save(Patient patient) {
      return this.patientRepository.save(patient);
   }

   @Override
   public Patient update(Patient patient) {
      return this.patientRepository.save(patient);
   }

   @Override
   public void delete(Long id) {
      this.patientRepository.deleteById(id);
   }

   @Override
   public Optional<Patient> findById(Long id) {
      return this.patientRepository.findById(id);
   }

   @Override
   public List<Patient> findAll() {
      return (List) this.patientRepository.findAll();
   }

   @Override
   public boolean existsByIdentification(String identification) {
      return this.patientRepository.existsByIdentification(identification);
   }
}
