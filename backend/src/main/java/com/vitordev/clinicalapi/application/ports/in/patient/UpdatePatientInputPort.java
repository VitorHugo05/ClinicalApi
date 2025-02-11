package com.vitordev.clinicalapi.application.ports.in.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;

public interface UpdatePatientInputPort {
    void update(Patient patient);
}
