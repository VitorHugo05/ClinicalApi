package com.vitordev.clinicalapi.infra.beans.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.DeleteConsultationByIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.DeleteConsultationByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteConsultationByIdConfig {
    @Bean
    public DeleteConsultationByIdUseCase deleteConsultationByIdUseCase(
            DeleteConsultationByIdOutputPort deleteConsultationByIdOutputPort,
            FindConsultationByIdInputPort findConsultationByIdInputPort
    ) {
        return new DeleteConsultationByIdUseCase(deleteConsultationByIdOutputPort, findConsultationByIdInputPort);
    }
}
