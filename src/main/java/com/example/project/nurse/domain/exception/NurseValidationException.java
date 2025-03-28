package com.example.project.nurse.domain.exception;

public class NurseValidationException extends RuntimeException{
   public NurseValidationException(String message){
      super(message);
   }
}
