package com.example.project;

import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.infraestructure.persistence.NurseRepositoryMySql;
import com.example.project.patient.domain.Gender;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.infraestructure.persistence.PatientRepositoryMySql;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MedicalDentalCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalDentalCenterApplication.class, args);
	}



}
