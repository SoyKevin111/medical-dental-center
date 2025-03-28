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


}
