package com.vitordev.clinicalapi.application.core.usecase;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.in.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.FindDoctorByIdOutputPort;

public class FindDoctorByIdUseCase implements FindDoctorByIdInputPort {
    private final FindDoctorByIdOutputPort findDoctorByIdOutputPort;

    public FindDoctorByIdUseCase(FindDoctorByIdOutputPort findDoctorByIdOutputPort) {
        this.findDoctorByIdOutputPort = findDoctorByIdOutputPort;
    }

    @Override
    public Doctor find(Long id) {
        return findDoctorByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
}
