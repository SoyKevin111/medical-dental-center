package com.example.project.diagnostic.infraestructure.adapter.out.persistence;

import com.example.project.diagnostic.domain.model.Symptom;
import com.example.project.diagnostic.domain.port.out.ISymptomRepository;
import com.example.project.diagnostic.infraestructure.adapter.out.persistence.mysql.SymptomRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SymptomRepository implements ISymptomRepository {

   @Autowired
   private SymptomRepositoryMysql symptomRepository;


   @Override
   public Symptom save(Symptom symptom) {
      return this.symptomRepository.save(symptom);
   }

   @Override
   public List<Symptom> findAll() {
      return (List) this.symptomRepository.findAll();
   }
}
