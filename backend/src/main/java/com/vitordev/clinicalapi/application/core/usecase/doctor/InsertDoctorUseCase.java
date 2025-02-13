package com.vitordev.clinicalapi.application.core.usecase.doctor;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.core.domain.exceptions.DataAlreadyExistException;
import com.vitordev.clinicalapi.application.ports.in.doctor.InsertDoctorInputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.FindDoctorByEmailOutputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.InsertDoctorOutputPort;

public class InsertDoctorUseCase implements InsertDoctorInputPort {
    private final InsertDoctorOutputPort insertDoctorOutputPort;
    private final FindDoctorByEmailOutputPort findDoctorByEmailOutputPort;

    public InsertDoctorUseCase(
            InsertDoctorOutputPort insertDoctorOutputPort,
            FindDoctorByEmailOutputPort findDoctorByEmailOutputPort
    ) {
        this.insertDoctorOutputPort = insertDoctorOutputPort;
        this.findDoctorByEmailOutputPort = findDoctorByEmailOutputPort;
    }

    @Override
    public Doctor insert(Doctor doctor) {
        System.out.println(findDoctorByEmailOutputPort.find(doctor.getEmail()));
        if(!findDoctorByEmailOutputPort.find(doctor.getEmail()).isEmpty()) {
            throw new DataAlreadyExistException("Doctor already exists");
        };
        return insertDoctorOutputPort.insert(doctor);
    }
}
