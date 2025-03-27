package com.example.project.specialistDoctor.application;

import com.example.project.specialistDoctor.domain.ISpecialistDoctorUseCase;
import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.infraestructure.persistence.SpecialistDoctorRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistDoctorUseCase implements ISpecialistDoctorUseCase {

   @Autowired
   private SpecialistDoctorRepositoryMysql specialistDoctorRepositoryMysql;

   @Override
   public SpecialistDoctor create(SpecialistDoctor specialistDoctor) {
      try {
         return this.specialistDoctorRepositoryMysql.save(specialistDoctor);
      }
      catch (Exception e){
         throw new RuntimeException("Error al guardar el Doctor Especialista: "+e);
      }
   }

   @Override
   public List<SpecialistDoctor> findAll() {
      return (List) this.specialistDoctorRepositoryMysql.findAll();
   }
}
