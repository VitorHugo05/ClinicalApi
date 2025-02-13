package com.vitordev.clinicalapi.infra.beans.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.FindConsultationsByPatientIdAndDateUseCase;
import com.vitordev.clinicalapi.application.core.usecase.patient.FindPatientByIdUseCase;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdAndDateOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindConsultationByPatientIdAndDateConfig {
    @Bean
    public FindConsultationsByPatientIdAndDateUseCase findConsultationByPatientIdAndDateUseCase(
            FindConsultationsByPatientIdAndDateOutputPort findConsultationsByPatientIdAndDateOutputPort,
            FindPatientByIdUseCase findPatientByIdUseCase

    ){
        return new FindConsultationsByPatientIdAndDateUseCase(findConsultationsByPatientIdAndDateOutputPort, findPatientByIdUseCase);
    }
}
