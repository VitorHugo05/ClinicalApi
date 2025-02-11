package com.vitordev.clinicalapi.config.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.FindConsultationByPatientIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByPatientIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindConsultationsByPatientIdConfig {
    @Bean
    public FindConsultationByPatientIdUseCase findConsultationByPatientIdUseCase(
            FindConsultationsByPatientIdOutputPort findConsultationsByPatientIdOutputPort,
            FindPatientByIdInputPort findPatientByIdInputPort
    ) {
        return new FindConsultationByPatientIdUseCase(findConsultationsByPatientIdOutputPort, findPatientByIdInputPort);
    }
}
