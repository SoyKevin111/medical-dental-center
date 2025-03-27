package com.example.project.specialistDoctor.domain;

import java.util.List;

public interface ISpecialistDoctorUseCase {

   SpecialistDoctor create(SpecialistDoctor specialistDoctor);
   List<SpecialistDoctor> findAll();

}
