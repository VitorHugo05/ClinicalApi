package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByDoctorIdOutputPort;

import java.util.List;

public class FindConsultationByDoctorIdUseCase implements FindConsultationsByDoctorIdInputPort {
    private final FindConsultationsByDoctorIdOutputPort findConsultationsByDoctorIdOutputPort;
    private final FindDoctorByIdInputPort findDoctorByIdInputPort;

    public FindConsultationByDoctorIdUseCase(
            FindConsultationsByDoctorIdOutputPort findConsultationsByDoctorIdOutputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort
    ) {
        this.findConsultationsByDoctorIdOutputPort = findConsultationsByDoctorIdOutputPort;
        this.findDoctorByIdInputPort = findDoctorByIdInputPort;
    }

    @Override
    public List<Consultation> find(Long id){
        findDoctorByIdInputPort.find(id);
        return findConsultationsByDoctorIdOutputPort.find(id);
    }
}
