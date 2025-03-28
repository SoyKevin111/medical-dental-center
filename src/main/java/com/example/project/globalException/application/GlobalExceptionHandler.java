package com.example.project.globalException.application;

import com.example.project.globalException.domain.ErrorResponse;
import com.example.project.nurse.domain.exception.NurseValidationException;
import com.example.project.patient.domain.exception.PatientValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(NurseValidationException.class)
   public ResponseEntity<Object> handleNurseException(NurseValidationException ex){
      ErrorResponse errorResponse = new ErrorResponse("Nurse Error",ex.getMessage());
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
   }
   @ExceptionHandler(PatientValidationException.class)
   public ResponseEntity<?> handlePatientException(PatientValidationException ex){
      return ResponseEntity.badRequest().body(ex.getErrors());
   }

}
