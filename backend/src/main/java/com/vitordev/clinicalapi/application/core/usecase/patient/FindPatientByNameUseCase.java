package com.vitordev.clinicalapi.application.core.usecase.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.core.domain.exceptions.ObjectNotFoundException;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByNameInputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByNameOutputPort;

public class FindPatientByNameUseCase implements FindPatientByNameInputPort {
    private final FindPatientByNameOutputPort findPatientByNameOutputPort;

    public FindPatientByNameUseCase(FindPatientByNameOutputPort findPatientByNameOutputPort) {
        this.findPatientByNameOutputPort = findPatientByNameOutputPort;
    }

    @Override
    public Patient find(String name) {
        return findPatientByNameOutputPort.find(name).orElseThrow(() -> new ObjectNotFoundException("Patient not found"));
    }
}
