package com.example.project.specialistDoctor.domain.port.out;

import com.example.project.specialistDoctor.domain.SpecialistDoctor;

import java.util.List;


public interface ISpecialistDoctorRepository {
   SpecialistDoctor save(SpecialistDoctor specialistDoctor);
   List<SpecialistDoctor> findAll();
}
