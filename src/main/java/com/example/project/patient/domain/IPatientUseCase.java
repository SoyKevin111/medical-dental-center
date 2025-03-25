package com.example.project.patient.domain;

import java.util.List;
import java.util.Optional;

public interface IPatientUseCase {
   //get, add, delete, update
   Patient save(Patient patient);
   void delete(Long id);
   Optional<Patient> update(Patient patient);
   Optional<Patient> findById(Long id);
   List<Patient> findAll();
   boolean ifExistPatient(String identification);

}
