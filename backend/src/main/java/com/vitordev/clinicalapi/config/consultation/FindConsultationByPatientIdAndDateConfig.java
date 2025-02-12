package com.vitordev.clinicalapi.config.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.FindConsultationByPatientIdAndDateUseCase;
import com.vitordev.clinicalapi.application.core.usecase.patient.FindPatientByIdUseCase;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdAndDateOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindConsultationByPatientIdAndDateConfig {
    @Bean
    public FindConsultationByPatientIdAndDateUseCase findConsultationByPatientIdAndDateUseCase(
            FindConsultationsByPatientIdAndDateOutputPort findConsultationsByPatientIdAndDateOutputPort,
            FindPatientByIdUseCase findPatientByIdUseCase

    ){
        return new FindConsultationByPatientIdAndDateUseCase(findConsultationsByPatientIdAndDateOutputPort, findPatientByIdUseCase);
    }
}
