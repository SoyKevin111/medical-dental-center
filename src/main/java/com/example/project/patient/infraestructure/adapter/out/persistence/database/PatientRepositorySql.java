package com.example.project.patient.infraestructure.adapter.out.persistence.database;

import com.example.project.patient.domain.Patient;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepositorySql extends CrudRepository<Patient, Long> {
   //save
   //delete
   //update(save)
   //Optional<Patient> findById();
   //findAll()
   boolean existsByIdentification(String identification);
}
