package com.example.project.nurse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NurseDto {

   String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
