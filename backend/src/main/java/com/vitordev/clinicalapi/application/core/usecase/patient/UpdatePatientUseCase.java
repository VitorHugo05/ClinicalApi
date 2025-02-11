package com.vitordev.clinicalapi.application.core.usecase.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.UpdatePatientInputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.UpdatePatientOutputPort;

public class UpdatePatientUseCase implements UpdatePatientInputPort {
    private final UpdatePatientOutputPort updatePatientOutputPort;
    private final FindPatientByIdInputPort findPatientByIdInputPort;

    public UpdatePatientUseCase(
            UpdatePatientOutputPort updatePatientOutputPort,
            FindPatientByIdInputPort findPatientByIdInputPort
    ) {
        this.updatePatientOutputPort = updatePatientOutputPort;
        this.findPatientByIdInputPort = findPatientByIdInputPort;
    }

    @Override
    public void update(Patient patient) {
        findPatientByIdInputPort.find(patient.getId());
        updatePatientOutputPort.update(patient);
    }
}
