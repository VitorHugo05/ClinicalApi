package com.vitordev.clinicalapi.application.ports.out.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;

import java.util.Optional;

public interface FindPatientByNameOutputPort {
    Optional<Patient> find(String name);
}
