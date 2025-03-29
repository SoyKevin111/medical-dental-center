package com.example.project.diagnostic.domain.port.out;

import com.example.project.diagnostic.domain.model.Symptom;

import java.util.List;

public interface ISymptomRepository {
   Symptom save(Symptom symptom);
   List<Symptom> findAll();
}
