package com.vitordev.clinicalapi.application.core.usecase.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.core.domain.exceptions.DataAlreadyExistException;
import com.vitordev.clinicalapi.application.ports.in.patient.InsertPatientInputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByEmailOutputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.InsertPatientOutputPort;

public class InsertPatientUseCase implements InsertPatientInputPort {
    private final InsertPatientOutputPort insertPatientOutputPort;
    private final FindPatientByEmailOutputPort findPatientByEmailOutputPort;

    public InsertPatientUseCase(
            InsertPatientOutputPort insertPatientOutputPort,
            FindPatientByEmailOutputPort findPatientByEmailOutputPort
    ) {
        this.insertPatientOutputPort = insertPatientOutputPort;
        this.findPatientByEmailOutputPort = findPatientByEmailOutputPort;
    }

    @Override
    public Patient insert(Patient patient) {
        if(findPatientByEmailOutputPort.find(patient.getEmail()).isPresent()) {
            throw new DataAlreadyExistException("Doctor already exists");
        }
        return insertPatientOutputPort.insert(patient);
    }
}
