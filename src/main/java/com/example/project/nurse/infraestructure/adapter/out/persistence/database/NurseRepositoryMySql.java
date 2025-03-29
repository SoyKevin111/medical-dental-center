package com.example.project.nurse.infraestructure.adapter.out.persistence.database;

import com.example.project.nurse.domain.Nurse;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("mysql")
public interface NurseRepositoryMySql extends CrudRepository<Nurse, Long>{
   @Query(value = "SELECT * FROM nurse ORDER BY RAND() LIMIT 1", nativeQuery = true)
   Nurse findRandomNurse();

   Optional<Nurse> findByName(String name);
}
