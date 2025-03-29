package com.example.project.nurse.infraestructure.adapter.out.persistence;

import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.port.out.INurseRepository;
import com.example.project.nurse.infraestructure.adapter.out.persistence.database.NurseRepositoryMySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NurseRepository implements INurseRepository {

   @Autowired
   private NurseRepositoryMySql nurseRepository;

   @Override
   public Optional<Nurse> getNurseById(Long id) {
      return nurseRepository.findById(id);
   }

   @Override
   public Optional<Nurse> findByName(String name) {
      return this.nurseRepository.findByName(name);
   }

   @Override
   public Optional<Nurse> findById(Long id) {
      return this.nurseRepository.findById(id);
   }

   @Override
   public Nurse findRandomNurse() {
      return this.nurseRepository.findRandomNurse();
   }

   @Override
   public Nurse save(Nurse nurse) {
      return this.nurseRepository.save(nurse);
   }

   @Override
   @SuppressWarnings({"rawtypes","unchecked"})
   public List<Nurse> findAll() {
      return (List) this.nurseRepository.findAll();
   }
}
