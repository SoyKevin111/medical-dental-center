package com.example.project.specialistDoctor.infraestructure.adapter.in.rest;

import com.example.project.specialistDoctor.application.SpecialistDoctorUseCase;
import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.domain.port.in.ISpecialistDoctorController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-center/staff/specialistDoctors")
public class SpecialistDoctorController implements ISpecialistDoctorController {

   @Autowired
   private SpecialistDoctorUseCase specialistDoctorUseCase;

   @GetMapping
   public List<SpecialistDoctor> findAll(){
      return this.specialistDoctorUseCase.findAllSpecialistDoctor();
   }

   @PostMapping
   public ResponseEntity<SpecialistDoctor> create(@RequestBody SpecialistDoctor specialistDoctor){
      return ResponseEntity.status(HttpStatus.CREATED).body(this.specialistDoctorUseCase.create(specialistDoctor));
   }
}
