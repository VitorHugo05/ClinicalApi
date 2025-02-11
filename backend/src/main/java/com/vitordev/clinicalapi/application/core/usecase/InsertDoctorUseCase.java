package com.vitordev.clinicalapi.application.core.usecase;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.in.InsertDoctorInputPort;
import com.vitordev.clinicalapi.application.ports.out.InsertDoctorOutputPort;

public class InsertDoctorUseCase implements InsertDoctorInputPort {
    private final InsertDoctorOutputPort insertDoctorOutputPort;

    public InsertDoctorUseCase(InsertDoctorOutputPort insertDoctorOutputPort) {
        this.insertDoctorOutputPort = insertDoctorOutputPort;
    }

    @Override
    public void insert(Doctor doctor) {
        insertDoctorOutputPort.insert(doctor);
    }
}
