package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByPatientIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdOutputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;

import java.util.List;

public class FindConsultationByPatientIdUseCase implements FindConsultationsByPatientIdInputPort {
    private final FindConsultationsByPatientIdOutputPort findConsultationsByPatientIdOutputPort;
    private final FindPatientByIdInputPort findPatientByIdInputPort;

    public FindConsultationByPatientIdUseCase(
            FindConsultationsByPatientIdOutputPort findConsultationsByPatientIdOutputPort,
            FindPatientByIdInputPort findPatientByIdInputPort
    ) {
        this.findConsultationsByPatientIdOutputPort = findConsultationsByPatientIdOutputPort;
        this.findPatientByIdInputPort = findPatientByIdInputPort;
    }

    @Override
    public List<Consultation> find(Long id) {
        findPatientByIdInputPort.find(id);
        return findConsultationsByPatientIdOutputPort.find(id);
    }
}
