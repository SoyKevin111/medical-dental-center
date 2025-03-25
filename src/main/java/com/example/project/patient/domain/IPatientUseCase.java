package com.example.project.patient.domain;

import java.util.List;
import java.util.Optional;

public interface IPatientUseCase {
   //get, add, delete, update
   Patient save(Patient patient);
   Optional<Patient> update(CreatePatient createPatient, Long id);
   void delete(Long id);
   Optional<Patient> findById(Long id);
   List<Patient> findAll();
   boolean existsByIdentification(String identification);

}
