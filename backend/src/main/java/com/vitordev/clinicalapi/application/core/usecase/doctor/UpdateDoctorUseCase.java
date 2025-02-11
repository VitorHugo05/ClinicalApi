package com.vitordev.clinicalapi.application.core.usecase.doctor;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.UpdateDoctorInputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.UpdateDoctorOutputPort;

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
