package com.example.project.symptom.application;

import com.example.project.symptom.domain.ISymptomUseCase;
import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.infraestructure.persistence.SymptomRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomUseCase implements ISymptomUseCase {

   @Autowired
   private SymptomRepositoryMysql symptomRepositoryMysql;

   @Override
   public Symptom create(Symptom symptom) {
      try {
         return this.symptomRepositoryMysql.save(symptom);
      }
      catch (Exception e){
         throw  new RuntimeException("Error al guardar el sintoma: "+e);
      }
   }

   @Override
   public List<Symptom> findAll() {
      return (List) this.symptomRepositoryMysql.findAll();
   }
}
