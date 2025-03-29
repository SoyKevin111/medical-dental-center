package com.example.project.patient.domain;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

   Long id;
   String name;
   String surname;
   Gender gender; //MALE, FEMALE, OTHER
   int age;
   String identification;

}