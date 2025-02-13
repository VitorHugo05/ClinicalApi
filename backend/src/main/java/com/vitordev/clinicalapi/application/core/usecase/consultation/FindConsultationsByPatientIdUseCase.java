package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.core.domain.exceptions.ObjectNotFoundException;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByPatientIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdOutputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;

import java.util.List;

public class FindConsultationsByPatientIdUseCase implements FindConsultationsByPatientIdInputPort {
    private final FindConsultationsByPatientIdOutputPort findConsultationsByPatientIdOutputPort;
    private final FindPatientByIdInputPort findPatientByIdInputPort;

    public FindConsultationsByPatientIdUseCase(
            FindConsultationsByPatientIdOutputPort findConsultationsByPatientIdOutputPort,
            FindPatientByIdInputPort findPatientByIdInputPort
    ) {
        this.findConsultationsByPatientIdOutputPort = findConsultationsByPatientIdOutputPort;
        this.findPatientByIdInputPort = findPatientByIdInputPort;
    }

    @Override
    public List<Consultation> find(Long id) {
        findPatientByIdInputPort.find(id);
        return findConsultationsByPatientIdOutputPort.find(id)
                .orElseThrow(() -> new ObjectNotFoundException("Consultation not found"));
    }
}
