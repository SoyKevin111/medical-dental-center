package com.example.project.utils.exception;

import java.util.List;

public class GeneralValidationException extends RuntimeException {
   private List<String> errors;

   public GeneralValidationException(String type, List<String> errors) {
      super(type);
      this.errors = errors;
   }

   public List<String> getErrors(){
      return errors;
   }

}
