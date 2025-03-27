package com.example.project.nurse.infraestructure.adapter.in.rest;

import com.example.project.nurse.application.usecase.NurseUseCase;
import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.NurseDto;
import com.example.project.nurse.domain.NurseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medical-center/staff/nurses")
public class NurseController {

   @Autowired
   private NurseUseCase nurseUseCase;
   @Autowired
   private NurseMapper nurseMapper;

   @GetMapping("/{id}")
   public ResponseEntity<?> getNurseById(@PathVariable Long id){
      Optional<Nurse> oNurse = nurseUseCase.getNurseById(id);
      if(oNurse.isPresent()){
         Nurse nurse = oNurse.get();
         return ResponseEntity.ok(nurseMapper.nurseToNurseDto(nurse));
      }
      else{
         return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Collections.singletonMap("error","Enfermera con id: "+id+" no encontrada."));
      }
   }

   @PostMapping
   public ResponseEntity<?> create( @RequestBody Nurse nurse){
      return ResponseEntity.status(HttpStatus.CREATED).body(this.nurseUseCase.save(nurse));
   }

   @GetMapping
   public List<Nurse> findAll(){
      return this.nurseUseCase.findAll();
   }

   @GetMapping("/random")
   public NurseDto findRandomNurse(){
      Nurse nurse = this.nurseUseCase.findRandomNurse();
      return nurseMapper.nurseToNurseDto(nurse);
   }

}
