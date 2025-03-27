package com.example.project.specialistDoctor.infraestructure.persistence;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialistDoctorRepositoryMysql extends CrudRepository<SpecialistDoctor, Long> {
}
