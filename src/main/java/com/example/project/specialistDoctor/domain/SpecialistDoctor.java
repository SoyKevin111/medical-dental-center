package com.example.project.specialistDoctor.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecialistDoctor {

   Long id;
   String name;
   String specialty;

}
