package com.example.project.specialistDoctor.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "symptom")
@Builder
public class SpecialistDoctor {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @Column(name = "name", unique = true)
   String name;

   @Column(name = "specialty")
   String specialty;



}
