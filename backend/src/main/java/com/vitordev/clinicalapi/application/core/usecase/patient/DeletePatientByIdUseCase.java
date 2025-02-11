package com.vitordev.clinicalapi.application.core.usecase.patient;

import com.vitordev.clinicalapi.application.ports.in.patient.DeletePatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.DeletePatientByIdOutputPort;

public class DeletePatientByIdUseCase implements DeletePatientByIdInputPort {
    private final DeletePatientByIdOutputPort deletePatientByIdOutputPort;
    private final FindPatientByIdInputPort findPatientByIdInputPort;

    public DeletePatientByIdUseCase(
            DeletePatientByIdOutputPort deletePatientByIdOutputPort,
            FindPatientByIdInputPort findPatientByIdInputPort
    ) {
        this.deletePatientByIdOutputPort = deletePatientByIdOutputPort;
        this.findPatientByIdInputPort = findPatientByIdInputPort;
    }

    @Override
    public void delete(Long id) {
        findPatientByIdInputPort.find(id);
        deletePatientByIdOutputPort.delete(id);
    }
}
