package com.vitordev.clinicalapi.application.core.usecase.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.in.patient.InsertPatientInputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.InsertPatientOutputPort;

public class InsertPatientUseCase implements InsertPatientInputPort {
    private final InsertPatientOutputPort insertPatientOutputPort;

    public InsertPatientUseCase(InsertPatientOutputPort insertPatientOutputPort) {
        this.insertPatientOutputPort = insertPatientOutputPort;
    }

    @Override
    public void insert(Patient patient) {
        insertPatientOutputPort.insert(patient);
    }
}
