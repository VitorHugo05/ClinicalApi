package com.vitordev.clinicalapi.adapters.out.patient.repository;

import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    Optional<PatientEntity> findByName(String name);

    Optional<PatientEntity> findByEmail(String email);
}
