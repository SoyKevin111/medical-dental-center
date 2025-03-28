package com.example.project.patient.domain.exception;

import java.util.List;

public class PatientValidationException extends  RuntimeException{

   private List<String> errors;

   public PatientValidationException(List<String> errors) {
      super("Error de validacion Paciente.");
      this.errors = errors;
   }

   public List<String> getErrors(){
      return errors;
   }
}
