package com.vitordev.clinicalapi.application.ports.in.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;

public interface FindPatientByNameInputPort {
    Patient find(String name);
}
