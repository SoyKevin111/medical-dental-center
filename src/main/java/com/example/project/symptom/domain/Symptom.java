package com.example.project.symptom.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "specialistDoctor")
@Builder
public class Symptom {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

   @Column(name = "name", unique = true)
   String name;


}
