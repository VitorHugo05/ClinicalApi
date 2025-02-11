package com.vitordev.clinicalapi.application.core.usecase.doctor;

import com.vitordev.clinicalapi.application.ports.in.doctor.DeleteDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.DeleteDoctorByIdOutputPort;

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
