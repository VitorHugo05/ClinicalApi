package com.vitordev.clinicalapi.application.core.usecase.patient;

import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.FindDoctorByIdOutputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByIdOutputPort;

public class FindPatientByIdUseCase implements FindPatientByIdInputPort {
    private final FindPatientByIdOutputPort findPatientByIdOutputPort;

    public FindPatientByIdUseCase(FindPatientByIdOutputPort findPatientByIdOutputPort) {
        this.findPatientByIdOutputPort = findPatientByIdOutputPort;

    }

    public Patient find(Long id) {
        return findPatientByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
}
