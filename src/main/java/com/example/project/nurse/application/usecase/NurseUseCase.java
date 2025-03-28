package com.example.project.nurse.application.usecase;

import com.example.project.nurse.domain.exception.NurseValidationException;
import com.example.project.nurse.domain.port.in.INurseUseCase;
import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.domain.port.out.INurseRepository;
import com.example.project.nurse.domain.validation.NurseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NurseUseCase implements INurseUseCase {

   @Autowired
   private INurseRepository nurseRepository;

   private final NurseValidator nurseValidator;

   public NurseUseCase(NurseValidator nurseValidator){
      this.nurseValidator = nurseValidator;
   }

   @Override
   @Transactional(readOnly = true)
   public Optional<Nurse> getNurseById(Long id) {
      return Optional.ofNullable(this.nurseRepository.findById(id)
         .orElseThrow(() -> new NurseValidationException("Enfermera no encontrada.")));
   }

   @Override
   @Transactional
   public Nurse save(Nurse nurse) {
      nurseValidator.validate(nurse.getName());
      Optional<Nurse> existingNurse = this.nurseRepository.findByName(nurse.getName());
      existingNurse.ifPresent(n -> {
         throw new NurseValidationException("El nombre de la enfermera ya esta en uso.");
      });
      return this.nurseRepository.save(nurse);
   }

   @SuppressWarnings({"rawtypes","unchecked"})
   @Override
   @Transactional(readOnly = true)
   public List<Nurse> findAll() {
      return (List) this.nurseRepository.findAll();
   }

   @Override
   public Nurse findRandomNurse() {
      return this.nurseRepository.findRandomNurse();
   }
}
