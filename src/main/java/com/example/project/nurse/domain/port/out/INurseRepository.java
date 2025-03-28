package com.example.project.nurse.domain.port.out;

import com.example.project.nurse.domain.Nurse;

import java.util.List;
import java.util.Optional;

public interface INurseRepository {
   Optional<Nurse> getNurseById(Long id);
   Optional<Nurse> findByName(String name);
   Optional<Nurse> findById(Long id);
   Nurse findRandomNurse();
   Nurse save(Nurse nurse);
   List<Nurse> findAll();
}
