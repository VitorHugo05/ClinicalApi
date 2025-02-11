package com.vitordev.clinicalapi.application.ports.out.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;

import java.util.Optional;

public interface FindPatientByIdOutputPort {
    Optional<Patient> find(Long id);
}
