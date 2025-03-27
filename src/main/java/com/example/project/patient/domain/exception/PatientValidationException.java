package com.example.project.patient.domain.exception;

public class PatientValidationException extends  RuntimeException{
   public PatientValidationException(String message) {
      super(message);
   }
}
