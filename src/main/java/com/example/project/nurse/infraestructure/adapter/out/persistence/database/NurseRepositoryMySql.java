package com.example.project.nurse.infraestructure.adapter.out.persistence.database;

import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.infraestructure.adapter.out.persistence.entity.NurseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NurseRepositoryMySql extends CrudRepository<NurseEntity, Long>{
   @Query(value = "SELECT * FROM nurse ORDER BY RAND() LIMIT 1", nativeQuery = true)
   NurseEntity findRandomNurse();

   boolean existsByName(String name);

}
