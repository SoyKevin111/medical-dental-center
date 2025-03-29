package com.example.project.diagnostic.domain.port.in;

import com.example.project.diagnostic.domain.model.Symptom;

import java.util.List;

public interface ISymptomUseCase {

   Symptom create(Symptom symptom);
   List<Symptom> findAll();

}
