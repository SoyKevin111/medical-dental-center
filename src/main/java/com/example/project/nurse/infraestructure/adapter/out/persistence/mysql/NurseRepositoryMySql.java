package com.example.project.nurse.infraestructure.adapter.out.persistence.mysql;

import com.example.project.nurse.domain.Nurse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NurseRepositoryMySql extends CrudRepository<Nurse, Long>{
   //en este caso si, porque usa @Query
   @Query(value = "SELECT * FROM nurse ORDER BY RAND() LIMIT 1", nativeQuery = true)
   Nurse findRandomNurse();
   Optional<Nurse> findByName(String name);
}
