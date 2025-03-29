package com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.mapper;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import org.springframework.stereotype.Component;

@Component
public class SpecialistDoctorMapper {

   // Convertir de Entity a Domain
   public SpecialistDoctor toDomain(SpecialistDoctorEntity entity) {
      if (entity == null) {
         return null;
      }
      return new SpecialistDoctor(
         entity.getId(),
         entity.getName(),
         entity.getSpecialty()
      );
   }

   // Convertir de Domain a Entity
   public SpecialistDoctorEntity toEntity(SpecialistDoctor domain) {
      if (domain == null) {
         return null;
      }
      return SpecialistDoctorEntity.builder()
         .id(domain.getId())
         .name(domain.getName())
         .specialty(domain.getSpecialty())
         .build();
   }

}
