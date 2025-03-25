package com.example.project.nurse.application.usecase;

import com.example.project.nurse.domain.INurseUseCase;
import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.infraestructure.persistence.NurseRepositoryMySql;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NurseUseCase implements INurseUseCase {

   @Autowired
   private NurseRepositoryMySql nurseRepositoryMysql;

   @Override
   @Transactional(readOnly = true)
   public Optional<Nurse> getNurseById(Long id) {
      return this.nurseRepositoryMysql.getNurseById(id);
   }

   @Override
   @Transactional
   public Nurse save(Nurse nurse) {
      try {
         return this.nurseRepositoryMysql.save(nurse);
      }catch (PersistenceException e){
         throw new RuntimeException("El nombre de la enfermera ya esta en uso.");
      }
   }
   @Override
   @Transactional(readOnly = true)
   public List<Nurse> findAll() {
      return (List) this.nurseRepositoryMysql.findAll();
   }

   @Override
   public Nurse findRandomNurse() {

      return this.nurseRepositoryMysql.findRandomNurse();
   }
}
