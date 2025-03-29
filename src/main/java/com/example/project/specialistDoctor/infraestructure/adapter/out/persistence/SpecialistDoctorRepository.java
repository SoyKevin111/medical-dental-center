package com.example.project.specialistDoctor.infraestructure.adapter.out.persistence;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.domain.port.out.ISpecialistDoctorRepository;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.mapper.SpecialistDoctorMapper;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.database.SpecialistDoctorRepositorySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecialistDoctorRepository implements ISpecialistDoctorRepository {

   @Autowired
   private SpecialistDoctorRepositorySql specialistDoctorRepository;

   @Autowired
   private SpecialistDoctorMapper specialistDoctorMapper;

   @Override
   public SpecialistDoctor save(SpecialistDoctor specialistDoctor) {
      SpecialistDoctorEntity specialistDoctorEntity = this.specialistDoctorRepository.save(this.specialistDoctorMapper.toEntity(specialistDoctor));
      return this.specialistDoctorMapper.toDomain(specialistDoctorEntity);
   }

   @SuppressWarnings({"rawtypes","unchecked"})
   @Override
   public List<SpecialistDoctor> findAll() {
      List<SpecialistDoctorEntity> spDoctorEntity = (List) this.specialistDoctorRepository.findAll();
      return ((List<SpecialistDoctorEntity>) this.specialistDoctorRepository.findAll())
         .stream()
         .map(e -> this.specialistDoctorMapper.toDomain(e))
         .toList();
   }
}
