package com.example.project.diagnostic.infraestructure.adapter.out.persistence.mysql;

import com.example.project.diagnostic.domain.model.Symptom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepositoryMysql extends CrudRepository<Symptom, Long> {
}
