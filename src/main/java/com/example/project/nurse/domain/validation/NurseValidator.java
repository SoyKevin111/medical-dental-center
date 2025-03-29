package com.example.project.nurse.domain.validation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NurseValidator {

   public List<String> validateNurseData(String name){
      List<String> errors = new ArrayList<>();

      if( name == null ||  name.isEmpty()){ //excede caracteres
         errors.add("Nombre ingresado indefinido.");
      }
      if(name.length() > 30){
         errors.add("El nombre no debe superar +30 caracteres.");
      }

      return errors;

   }


}
