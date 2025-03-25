package com.example.project.patient.infraestructure.persistence;

import com.example.project.patient.domain.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepositoryMySql extends CrudRepository<Patient, Long> {
   //save
   //delete
   //update(save)
   Optional<Patient> findByIndetification(String identification);
   //findAll()
   boolean existsByIdentification(String identification);
}
