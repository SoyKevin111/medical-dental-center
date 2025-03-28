package com.example.project.patient.domain.validation;

import com.example.project.patient.domain.Gender;
import com.example.project.patient.domain.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PatientValidator {

   public List<String> validatePatientData(Patient patient) {
      List<String> errors = new ArrayList<>();

      if (patient.getAge() < 3 || patient.getAge() > 100) {
         errors.add("Edad menor a 3 o mayor a 100 no esta definido.");
      }

      if ( patient.getIdentification() == null || patient.getIdentification().length() != 10) {
         errors.add("Longitud de Identificación debe ser 10.");
      }


      if (patient.getGender() == null || patient.getGender().toString().isEmpty()) {
         errors.add("Error propiedad Género no definida o vacia.");
      } else {
         String genderError = validateGender(patient.getGender()); //no funciona la validacion por tipo
         if (genderError != null) {
            errors.add(genderError);
         }
      }

      if (patient.getName() == null || patient.getName().isEmpty()) {
         errors.add("Nombre ingresado esta vacio.");
      }

      if (patient.getSurname() == null || patient.getSurname().isEmpty()) {
         errors.add("Apellido ingresado esta vacio.");
      }

      return errors;
   }

   public List<String> validateRequestPatientData(int age, String name, String surname) {
      List<String> errors = new ArrayList<>();

      if (age < 3 || age > 100) {
         errors.add("Edad menor a 3 o mayor a 100 no esta permitido.");
      }

      if (name.isEmpty()) {
         errors.add("Nombre ingresado esta vacio.");
      }

      if (surname.isEmpty()) {
         errors.add("Apellido ingresado esta vacio.");
      }

      return errors;
   }


   public String validateGender(Gender gender) {
      boolean isValid = Arrays.stream(Gender.values())
         .anyMatch(g -> g.equals(gender));

      if (isValid) {
         return null;
      } else {
         return "Tipo de género ingresado incorrecto.";
      }
   }


}
