package com.example.project.nurse.domain;

import java.util.List;
import java.util.Optional;

public interface INurseUseCase {

   Optional<Nurse> getNurseById(Long id);
   Nurse save(Nurse nurse);
   List<Nurse> findAll();
   Nurse findRandomNurse();
}
