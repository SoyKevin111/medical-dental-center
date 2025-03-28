package com.example.project.nurse.domain;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NurseMapper {

   public NurseDto nurseToNurseDto(Nurse nurse) {
      return NurseDto.builder()
         .name(nurse.getName())
         .build();
   }

   public NurseDto optionalNurseToNurseDto(Optional<Nurse> optionalNurse){
      return NurseDto.builder()
         .name(optionalNurse.orElseThrow().getName())
         .build();
   }

}
