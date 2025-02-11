package com.vitordev.clinicalapi.application.core.usecase;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.in.DeleteDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.DeleteDoctorByIdOutputPort;

public class DeleteDoctorByIdUseCase implements DeleteDoctorByIdInputPort {

    private final FindDoctorByIdInputPort findDoctorByIdInputPort;
    private final DeleteDoctorByIdOutputPort deleteDoctorByIdOutputPort;

    public DeleteDoctorByIdUseCase(
            FindDoctorByIdInputPort findDoctorByIdInputPort,
            DeleteDoctorByIdOutputPort deleteDoctorByIdOutputPort
    ) {
        this.findDoctorByIdInputPort = findDoctorByIdInputPort;
        this.deleteDoctorByIdOutputPort = deleteDoctorByIdOutputPort;
    }

    @Override
    public void delete(Long id){
        findDoctorByIdInputPort.find(id);
        deleteDoctorByIdOutputPort.delete(id);
    }
}
