package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.core.domain.exceptions.ObjectNotFoundException;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByDoctorIdOutputPort;

import java.util.List;

public class FindConsultationsByDoctorIdUseCase implements FindConsultationsByDoctorIdInputPort {
    private final FindConsultationsByDoctorIdOutputPort findConsultationsByDoctorIdOutputPort;
    private final FindDoctorByIdInputPort findDoctorByIdInputPort;

    public FindConsultationsByDoctorIdUseCase(
            FindConsultationsByDoctorIdOutputPort findConsultationsByDoctorIdOutputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort
    ) {
        this.findConsultationsByDoctorIdOutputPort = findConsultationsByDoctorIdOutputPort;
        this.findDoctorByIdInputPort = findDoctorByIdInputPort;
    }

    @Override
    public List<Consultation> find(Long id){
        findDoctorByIdInputPort.find(id);
        return findConsultationsByDoctorIdOutputPort.find(id)
                .orElseThrow(() -> new ObjectNotFoundException("Consultation not found"));
    }
}
