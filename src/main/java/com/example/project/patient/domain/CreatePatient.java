package com.example.project.patient.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreatePatient(
   @NotBlank(message = "name obligatory") String name,
   @NotBlank(message = "surname obligatory") String surname,
   @Min(value = 3, message = "Min limit 3 years")
   @Max(value = 100, message = "Max limit 100 years")
   @NotBlank(message = "age obligatory") int age
) {

   public static void main(String[] args) {
      CreatePatient c = new CreatePatient("kevin", "steven",101);
      if(c.age>3 && c.age<=100){
         System.out.println("Paciente Permitido");
      }
      else {
         System.out.println("Paciente Denegado");
      }
   }

}
