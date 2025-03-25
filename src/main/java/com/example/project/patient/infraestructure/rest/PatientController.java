package com.example.project.patient.infraestructure.rest;

import com.example.project.patient.application.usecase.PatientUseCase;
import com.example.project.patient.domain.CreatePatient;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.exception.PatientValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/medical-center/staff/patients")
public class PatientController {

   @Autowired
   private PatientUseCase patientUseCase;

   @PutMapping("/{}")
   public ResponseEntity<Patient> updatePatient(@RequestBody CreatePatient createPatient, @PathVariable Long id){

      if(!createPatient.isValidateAge()){
         throw new PatientValidationException("Edad fuera de RANGO min:3 max:100");
      }
      Optional<Patient> optionalPatient = this.patientUseCase.update(createPatient, id);
      if(optionalPatient.isPresent()){
         return ResponseEntity.ok(optionalPatient.orElseThrow());
      }
      return ResponseEntity.notFound().build();
   }
}
