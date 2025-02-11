package com.vitordev.clinicalapi.adapters.out.patient.repository;

import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
