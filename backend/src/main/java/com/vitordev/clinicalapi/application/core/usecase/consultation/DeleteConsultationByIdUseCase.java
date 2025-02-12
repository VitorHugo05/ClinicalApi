package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.ports.in.consultation.DeleteConsultationByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.DeleteConsultationByIdOutputPort;

public class DeleteConsultationByIdUseCase implements DeleteConsultationByIdInputPort {
    private final DeleteConsultationByIdOutputPort deleteConsultationByIdOutputPort;
    private final FindConsultationByIdInputPort findConsultationByIdInputPort;

    public DeleteConsultationByIdUseCase(
            DeleteConsultationByIdOutputPort deleteConsultationByIdOutputPort,
            FindConsultationByIdInputPort findConsultationByIdInputPort
    ) {
        this.deleteConsultationByIdOutputPort = deleteConsultationByIdOutputPort;
        this.findConsultationByIdInputPort = findConsultationByIdInputPort;
    }

    @Override
    public void delete(Long id) {
        findConsultationByIdInputPort.find(id);
        deleteConsultationByIdOutputPort.delete(id);
    }
}
