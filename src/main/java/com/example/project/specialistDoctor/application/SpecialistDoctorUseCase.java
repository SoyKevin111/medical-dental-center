package com.example.project.specialistDoctor.application;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.domain.port.in.ISpecialistDoctorUseCase;
import com.example.project.specialistDoctor.domain.port.out.ISpecialistDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistDoctorUseCase implements ISpecialistDoctorUseCase {

   @Autowired
   private ISpecialistDoctorRepository specialistDoctorRepository;

   @Override
   public SpecialistDoctor create(SpecialistDoctor specialistDoctor) {
      try {
         return this.specialistDoctorRepository.save(specialistDoctor);
      }
      catch (Exception e){
         throw new RuntimeException("Error al guardar el Doctor Especialista: "+e);
      }
   }

   @SuppressWarnings({"rawtypes","unchecked"})
   @Override
   public List<SpecialistDoctor> findAllSpecialistDoctor() {
      return (List) this.specialistDoctorRepository.findAll();
   }
}
