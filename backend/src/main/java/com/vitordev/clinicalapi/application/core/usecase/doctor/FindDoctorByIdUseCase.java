package com.vitordev.clinicalapi.application.core.usecase.doctor;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.core.domain.exceptions.ObjectNotFoundException;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.FindDoctorByIdOutputPort;

public class FindDoctorByIdUseCase implements FindDoctorByIdInputPort {
    private final FindDoctorByIdOutputPort findDoctorByIdOutputPort;

    public FindDoctorByIdUseCase(FindDoctorByIdOutputPort findDoctorByIdOutputPort) {
        this.findDoctorByIdOutputPort = findDoctorByIdOutputPort;
    }

    @Override
    public Doctor find(Long id) {
        return findDoctorByIdOutputPort.find(id).orElseThrow(() -> new ObjectNotFoundException("Doctor not found"));
    }
}
