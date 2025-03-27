package com.example.project.symptom.domain;

import java.util.List;

public interface ISymptomUseCase {

   Symptom create(Symptom symptom);
   List<Symptom> findAll();

}
