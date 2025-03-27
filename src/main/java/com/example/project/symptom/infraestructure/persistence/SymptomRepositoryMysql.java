package com.example.project.symptom.infraestructure.persistence;

import com.example.project.symptom.domain.Symptom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepositoryMysql extends CrudRepository<Symptom, Long> {
}
