package com.vitordev.clinicalapi.application.ports.out.patient;

import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;

import java.util.Optional;

public interface FindPatientByEmailOutputPort {
    Optional<PatientEntity> find(String email);
}
