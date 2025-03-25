package com.example.project.medicalcenter.application.usecase;

import com.example.project.medicalcenter.domain.IMedicalCenterUseCase;
import com.example.project.medicalcenter.domain.MedicalCenter;
import org.springframework.stereotype.Service;

@Service
public class MedicalCenterUseCase implements IMedicalCenterUseCase {


   @Override
   public String getMedicalCenterName() {
      MedicalCenter medicalCenter = new MedicalCenter();
      return medicalCenter.getName();
   }
}
