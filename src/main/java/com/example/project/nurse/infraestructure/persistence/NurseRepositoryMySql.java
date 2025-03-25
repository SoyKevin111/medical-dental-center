package com.example.project.nurse.infraestructure.persistence;

import com.example.project.nurse.domain.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NurseRepositoryMySql extends JpaRepository<Nurse, Long> {
   Optional<Nurse> getNurseById(Long id);
   //save generado automaticamente
   //findAll generado automaticamente
   @Query(value = "SELECT * FROM nurse ORDER BY RAND() LIMIT 1", nativeQuery = true)
   Nurse findRandomNurse();
}
