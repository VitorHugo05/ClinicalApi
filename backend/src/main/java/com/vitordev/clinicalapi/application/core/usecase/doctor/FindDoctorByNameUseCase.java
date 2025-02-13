package com.vitordev.clinicalapi.application.core.usecase.doctor;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.core.domain.exceptions.ObjectNotFoundException;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByNameInputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.FindDoctorByNameOutputPort;

public class FindDoctorByNameUseCase implements FindDoctorByNameInputPort {
    private final FindDoctorByNameOutputPort findDoctorByNameOutputPort;

    public FindDoctorByNameUseCase(FindDoctorByNameOutputPort findDoctorByNameOutputPort) {
        this.findDoctorByNameOutputPort = findDoctorByNameOutputPort;
    }

    @Override
    public Doctor find(String name) {
        return findDoctorByNameOutputPort.find(name).orElseThrow(() -> new ObjectNotFoundException("Doctor not found"));
    }
}
