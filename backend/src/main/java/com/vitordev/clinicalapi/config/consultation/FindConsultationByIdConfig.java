package com.vitordev.clinicalapi.config.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.FindConsultationByIdUseCase;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindConsultationByIdConfig {
    @Bean
    public FindConsultationByIdUseCase findConsultationByIdUseCase(
            FindConsultationByIdOutputPort findConsultationByIdOutputPort
    ) {
        return new FindConsultationByIdUseCase(findConsultationByIdOutputPort);
    }
}
