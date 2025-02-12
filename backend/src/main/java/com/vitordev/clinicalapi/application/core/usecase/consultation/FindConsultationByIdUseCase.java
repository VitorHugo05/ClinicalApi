package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationByIdOutputPort;

public class FindConsultationByIdUseCase implements FindConsultationByIdInputPort {
    private final FindConsultationByIdOutputPort findConsultationByIdOutputPort;

    public FindConsultationByIdUseCase(
            FindConsultationByIdOutputPort findConsultationByIdOutputPort
    ) {
        this.findConsultationByIdOutputPort = findConsultationByIdOutputPort;
    }

    @Override
    public Consultation find(Long id) {
        return findConsultationByIdOutputPort.find(id);
    }
}
