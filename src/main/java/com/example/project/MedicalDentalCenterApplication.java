package com.example.project;

import com.example.project.nurse.domain.Nurse;
import com.example.project.nurse.infraestructure.persistence.NurseRepositoryMySql;
import com.example.project.patient.domain.Gender;
import com.example.project.patient.domain.Patient;
import com.example.project.patient.infraestructure.persistence.PatientRepositoryMySql;
import com.example.project.specialistDoctor.domain.SpecialistDoctor;
import com.example.project.specialistDoctor.infraestructure.persistence.SpecialistDoctorRepositoryMysql;
import com.example.project.symptom.domain.Symptom;
import com.example.project.symptom.infraestructure.persistence.SymptomRepositoryMysql;
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
	CommandLineRunner init(PatientRepositoryMySql patientRepository, NurseRepositoryMySql nurseRepository, SymptomRepositoryMysql symptomRepository, SpecialistDoctorRepositoryMysql specialistDoctorRepository){
		return args -> {
			Patient patien1 = Patient.builder()
				.name("Kevin 1")
				.surname("Stevennn")
				.age(20)
				.gender(Gender.MALE)
				.identification("0990204404")
				.build();
			Patient patient2 = Patient.builder()
				.name("Kevin 2")
				.surname("Stevennn")
				.age(20)
				.gender(Gender.MALE)
				.identification("0990204402")
				.build();

			Patient patient3 = Patient.builder()
				.name("Kevin 3")
				.surname("Stevennn")
				.age(20)
				.gender(Gender.MALE)
				.identification("0990204403")
				.build();

			Nurse nurse1 = Nurse.builder()
				.name("Florinda Guevara")
				.build();

			Nurse nurse2 = Nurse.builder()
				.name("Susana Manzana")
				.build();

			Symptom symptom1 = Symptom.builder().name("Fiebre").build();
			Symptom symptom2 = Symptom.builder().name("Dolor de muela").build();
			Symptom symptom3 = Symptom.builder().name("Bracket").build();
			Symptom symptom4 = Symptom.builder().name("Alergia").build();

			SpecialistDoctor specialistDoctor1 = SpecialistDoctor.builder().name("Kevin Steven").specialty("Odontologo General").build();
			SpecialistDoctor specialistDoctor2 = SpecialistDoctor.builder().name("Ferran Torres").specialty("Ortodoncista").build();
			SpecialistDoctor specialistDoctor3 = SpecialistDoctor.builder().name("Julio Encizo").specialty("Periodoncista").build();

			patientRepository.saveAll(List.of(patien1, patient2,patient3));
			nurseRepository.saveAll(List.of(nurse1,nurse2));
			symptomRepository.saveAll(List.of(symptom1,symptom2,symptom3,symptom4));
			specialistDoctorRepository.saveAll(List.of(specialistDoctor1,specialistDoctor2,specialistDoctor3));
		};
	}

}
