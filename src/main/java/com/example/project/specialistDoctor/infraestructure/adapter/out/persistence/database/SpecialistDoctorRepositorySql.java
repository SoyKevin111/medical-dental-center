package com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.database;

import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistDoctorRepositorySql extends CrudRepository<SpecialistDoctorEntity, Long> {
}
