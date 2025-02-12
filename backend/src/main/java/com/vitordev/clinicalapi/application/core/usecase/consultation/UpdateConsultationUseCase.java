package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.consultation.UpdateConsultationInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.UpdateConsultationOutputPort;

public class UpdateConsultationUseCase implements UpdateConsultationInputPort {
    private final UpdateConsultationOutputPort updateConsultationOutputPort;
    private final FindConsultationByIdInputPort findConsultationByIdInputPort;

    public UpdateConsultationUseCase(
            UpdateConsultationOutputPort updateConsultationOutputPort,
            FindConsultationByIdInputPort findConsultationByIdInputPort
    ) {
        this.updateConsultationOutputPort = updateConsultationOutputPort;
        this.findConsultationByIdInputPort = findConsultationByIdInputPort;
    }

    @Override
    public void update(Consultation consultation){
        findConsultationByIdInputPort.find(consultation.getId());
        updateConsultationOutputPort.update(consultation);
    }
}
