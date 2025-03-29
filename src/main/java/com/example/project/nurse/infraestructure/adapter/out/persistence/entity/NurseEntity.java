package com.example.project.nurse.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nurse")
@Builder
@Getter
@Setter
public class NurseEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true)
   private String name;
}
