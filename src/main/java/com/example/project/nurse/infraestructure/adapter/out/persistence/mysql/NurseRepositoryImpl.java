package com.example.project.nurse.infraestructure.adapter.out.persistence.mysql;

import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.port.out.INurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NurseRepositoryImpl implements INurseRepository {

   @Autowired
   private NurseRepositoryMySql nurseRepositoryMySql;

   @Override
   public Optional<Nurse> getNurseById(Long id) {
      return nurseRepositoryMySql.findById(id);
   }

   @Override
   public Nurse findRandomNurse() {
      return this.nurseRepositoryMySql.findRandomNurse();
   }

   @Override
   public Nurse save(Nurse nurse) {
      return this.nurseRepositoryMySql.save(nurse);
   }

   @Override
   @SuppressWarnings({"rawtypes","unchecked"})
   public List<Nurse> findAll() {
      return (List) this.nurseRepositoryMySql.findAll();
   }
}
