package com.example.project.patient.domain.validation;

import com.example.project.patient.domain.Gender;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.domain.RequestPatient;
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

   public List<String> validateRequestPatientData(RequestPatient requestPatient) {
      List<String> errors = new ArrayList<>();

      if (requestPatient.age() < 3 || requestPatient.age() > 100) {
         errors.add("Edad menor a 3 o mayor a 100 no esta permitido.");
      }

      if (requestPatient.name() ==null || requestPatient.name().isEmpty()) {
         errors.add("Nombre ingresado esta vacio.");
      }

      if (requestPatient.surname() ==null ||requestPatient.surname().isEmpty()) {
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
