package com.vitordev.clinicalapi.infra.beans.patient;

import com.vitordev.clinicalapi.application.core.usecase.patient.FindPatientByIdUseCase;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindPatientByIdConfig {
    @Bean
    public FindPatientByIdUseCase findPatientByIdUseCase(
            FindPatientByIdOutputPort findPatientByIdOutputPort
    ) {
        return new FindPatientByIdUseCase(findPatientByIdOutputPort);
    }
}
