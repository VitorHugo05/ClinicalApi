package com.vitordev.clinicalapi.config.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.FindConsultationsByPatientIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindConsultationsByPatientIdConfig {
    @Bean
    public FindConsultationsByPatientIdUseCase findConsultationByPatientIdUseCase(
            FindConsultationsByPatientIdOutputPort findConsultationsByPatientIdOutputPort,
            FindPatientByIdInputPort findPatientByIdInputPort
    ) {
        return new FindConsultationsByPatientIdUseCase(findConsultationsByPatientIdOutputPort, findPatientByIdInputPort);
    }
}
