package com.vitordev.clinicalapi.application.ports.in.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;

public interface FindPatientByIdInputPort {
    Patient find(Long id);
}
