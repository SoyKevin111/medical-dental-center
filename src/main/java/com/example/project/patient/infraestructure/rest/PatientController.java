package com.example.project.patient.infraestructure.rest;

import com.example.project.patient.application.usecase.PatientUseCase;
import com.example.project.patient.domain.RequestPatient;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.exception.PatientValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medical-center/staff/patients")
public class PatientController {

   @Autowired
   private PatientUseCase patientUseCase;

   @PutMapping("/{id}")
   public ResponseEntity<?> updatePatient(@RequestBody RequestPatient requestPatient, @PathVariable Long id){

      if(!requestPatient.isValidateAge()){
         throw new PatientValidationException("Edad fuera de RANGO min:3 max:100");
      }
      Optional<Patient> optionalPatient = this.patientUseCase.update(requestPatient, id);
      if(optionalPatient.isPresent()){
         return ResponseEntity.ok(optionalPatient.orElseThrow());
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","Paciente no encontrado para actualizar."));
   }

   @PostMapping
   public ResponseEntity<?> create(@RequestBody Patient patient){
      if(this.patientUseCase.existsByIdentification(patient.getIdentification())){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error","Error, paciente existente."));
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(this.patientUseCase.save(patient));
   }

   @GetMapping
   public List<Patient> findAll(){
      return this.patientUseCase.findAll();
   }

   @GetMapping("/{id}")
   public ResponseEntity<?> findById(@PathVariable Long id){
      Optional<Patient> optionalPatient = this.patientUseCase.findById(id);
      if(optionalPatient.isPresent()){
         return ResponseEntity.status(HttpStatus.OK).body(optionalPatient.orElseThrow());
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error","Error, Paciente no encontrado."));

   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> delete(@PathVariable Long id){
      Optional<Patient> optionalPatient = this.patientUseCase.findById(id);
      if(optionalPatient.isPresent()){
         this.patientUseCase.delete(id);
         return  ResponseEntity.status(HttpStatus.OK).body("Paciente "+optionalPatient.get().getName()+" eliminado correctamente. ");
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error","Paciente no encontrado para eliminar."));
   }
}
