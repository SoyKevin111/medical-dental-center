package com.example.project.nurse.domain;

import org.springframework.stereotype.Component;

@Component
public class NurseMapper {

   public NurseDto nurseToNurseDto(Nurse nurse) {
      return NurseDto.builder()
         .name(nurse.getName())
         .build();
   }
}
