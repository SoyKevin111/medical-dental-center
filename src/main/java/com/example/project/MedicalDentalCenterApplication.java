package com.example.project;

import com.example.project.nurse.infraestructure.adapter.out.persistence.database.NurseRepositoryMySql;
import com.example.project.nurse.infraestructure.adapter.out.persistence.entity.NurseEntity;
import com.example.project.patient.domain.Gender;
import com.example.project.patient.infraestructure.adapter.out.persistence.database.PatientRepositorySql;
import com.example.project.patient.infraestructure.adapter.out.persistence.entity.PatientEntity;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.entity.SpecialistDoctorEntity;
import com.example.project.specialistDoctor.infraestructure.adapter.out.persistence.database.SpecialistDoctorRepositorySql;
import com.example.project.diagnostic.domain.model.Symptom;
import com.example.project.diagnostic.infraestructure.adapter.out.persistence.mysql.SymptomRepositoryMysql;
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

	@Bean //Test
	CommandLineRunner init(PatientRepositorySql patientRepository, NurseRepositoryMySql nurseRepository, SymptomRepositoryMysql symptomRepository, SpecialistDoctorRepositorySql specialistDoctorRepository){
		return args -> {
			PatientEntity patien1 = PatientEntity.builder()
				.name("Kevin 1")
				.surname("Stevennn")
				.age(20)
				.gender(Gender.MALE)
				.identification("0990204404")
				.build();
			PatientEntity patient2 = PatientEntity.builder()
				.name("Kevin 2")
				.surname("Stevennn")
				.age(20)
				.gender(Gender.MALE)
				.identification("0990204402")
				.build();

			PatientEntity patient3 = PatientEntity.builder()
				.name("Kevin 3")
				.surname("Stevennn")
				.age(20)
				.gender(Gender.MALE)
				.identification("0990204403")
				.build();

			NurseEntity nurse1 = NurseEntity.builder()
				.name("Florinda Guevara")
				.build();

			NurseEntity nurse2 = NurseEntity.builder()
				.name("Susana Manzana")
				.build();

			Symptom symptom1 = Symptom.builder().name("Fiebre").build();
			Symptom symptom2 = Symptom.builder().name("Dolor de muela").build();
			Symptom symptom3 = Symptom.builder().name("Bracket").build();
			Symptom symptom4 = Symptom.builder().name("Alergia").build();

			SpecialistDoctorEntity specialistDoctorEntity1 = SpecialistDoctorEntity.builder().name("Kevin Steven").specialty("Odontologo General").build();
			SpecialistDoctorEntity specialistDoctorEntity2 = SpecialistDoctorEntity.builder().name("Ferran Torres").specialty("Ortodoncista").build();
			SpecialistDoctorEntity specialistDoctorEntity3 = SpecialistDoctorEntity.builder().name("Julio Encizo").specialty("Periodoncista").build();

			patientRepository.saveAll(List.of(patien1, patient2,patient3));
			nurseRepository.saveAll(List.of(nurse1,nurse2));
			symptomRepository.saveAll(List.of(symptom1,symptom2,symptom3,symptom4));
			specialistDoctorRepository.saveAll(List.of(specialistDoctorEntity1, specialistDoctorEntity2, specialistDoctorEntity3));
		};
	}

}
