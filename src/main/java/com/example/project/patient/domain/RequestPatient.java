package com.example.project.patient.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record RequestPatient(
   @NotBlank(message = "name obligatory") String name,
   @NotBlank(message = "surname obligatory") String surname,
   @Min(value = 3, message = "Min limit 3 years")
   @Max(value = 100, message = "Max limit 100 years")
   @NotBlank(message = "age obligatory") int age
) {

   public boolean isValidateAge(){
      return age >3 && age<=100; //si cumple, no cumple
   }

   public static void main(String[] args) {
      RequestPatient c = new RequestPatient("kevin", "steven",20);
      if(c.age>3 && c.age<=100){
         System.out.println("Paciente Permitido");
         System.out.println(c.toString());
      }
      else {
         System.out.println("Paciente Denegado");
      }
   }

}
