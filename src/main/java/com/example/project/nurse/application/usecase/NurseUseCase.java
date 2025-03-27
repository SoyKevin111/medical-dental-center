package com.example.project.nurse.application.usecase;

import com.example.project.nurse.domain.port.in.INurseUseCase;
import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.port.out.INurseRepository;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NurseUseCase implements INurseUseCase {

   @Autowired
   private INurseRepository nurseRepository;

   @Override
   @Transactional(readOnly = true)
   public Optional<Nurse> getNurseById(Long id) {
      return this.nurseRepository.getNurseById(id);
   }

   @Override
   @Transactional
   public Nurse save(Nurse nurse) {
      try {
         return this.nurseRepository.save(nurse);
      }catch (PersistenceException e){
         throw new RuntimeException("El nombre de la enfermera ya esta en uso.");
      }
   }
   @Override
   @Transactional(readOnly = true)
   public List<Nurse> findAll() {
      return (List) this.nurseRepository.findAll();
   }

   @Override
   public Nurse findRandomNurse() {
      return this.nurseRepository.findRandomNurse();
   }
}
