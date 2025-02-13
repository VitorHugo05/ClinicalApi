package com.vitordev.clinicalapi.application.ports.out.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;

public interface InsertPatientOutputPort {
    Patient insert(Patient patient);
}
