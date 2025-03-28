package com.example.project.nurse.domain.validation;

import com.example.project.nurse.domain.exception.NurseValidationException;
import org.springframework.stereotype.Component;

@Component
public class NurseValidator {
   public void validate(String value){
      if(value.length() > 5){
         throw new NurseValidationException("El nombre no debe superar "+5+" caracteres.");
      }
   }
}
