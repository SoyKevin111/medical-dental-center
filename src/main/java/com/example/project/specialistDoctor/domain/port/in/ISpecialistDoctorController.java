package com.example.project.specialistDoctor.domain.port.in;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISpecialistDoctorController {
   List<SpecialistDoctor> findAll();
   ResponseEntity<SpecialistDoctor> create(SpecialistDoctor specialistDoctor);
}
