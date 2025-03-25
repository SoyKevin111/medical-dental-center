package com.example.project.medicalcenter.infraestructure.rest;

import com.example.project.medicalcenter.domain.IMedicalCenterUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medical-center")
public class MedicalCenterController {

   private final IMedicalCenterUseCase medicalCenterUseCase;

   public MedicalCenterController(IMedicalCenterUseCase medicalCenterUseCase){
      this.medicalCenterUseCase = medicalCenterUseCase;
   }

   @GetMapping("/name")
   public String getMedicalCenterName(){
      return medicalCenterUseCase.getMedicalCenterName();
   }

}
