package com.example.project.patient.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @NotBlank(message = "name obligatory")
   String name;

   @NotBlank(message = "surname obligatory")
   String surname;

   @NotNull(message = "gender obligatory")
   @Enumerated(EnumType.STRING)
   Gender gender; //MALE, FEMALE, OTHER

   @Min(value = 3, message = "Min limit 3 years")
   @Max(value = 100, message = "Max Limit 100 years")
   int age;

   @Column(unique = true, length = 20)
   @NotBlank(message = "identification obligatory")
   String identification;

}
