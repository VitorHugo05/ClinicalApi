package com.vitordev.clinicalapi.application.core.usecase;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.in.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.UpdateDoctorInputPort;
import com.vitordev.clinicalapi.application.ports.out.UpdateDoctorOutputPort;

public class UpdateDoctorUseCase implements UpdateDoctorInputPort {

    private final UpdateDoctorOutputPort updateDoctorOutputPort;
    private final FindDoctorByIdInputPort findDoctorByIdInputPort;

    public UpdateDoctorUseCase(
            UpdateDoctorOutputPort updateDoctorOutputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort
    ) {
        this.updateDoctorOutputPort = updateDoctorOutputPort;
        this.findDoctorByIdInputPort = findDoctorByIdInputPort;
    }

    @Override
    public void update(Doctor doctor) {
        findDoctorByIdInputPort.find(doctor.getId());
        updateDoctorOutputPort.update(doctor);
    }
}
