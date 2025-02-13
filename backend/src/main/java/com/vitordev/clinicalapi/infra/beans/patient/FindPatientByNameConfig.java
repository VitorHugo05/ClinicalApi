package com.vitordev.clinicalapi.infra.beans.patient;

import com.vitordev.clinicalapi.application.core.usecase.patient.FindPatientByNameUseCase;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByNameOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindPatientByNameConfig {
    @Bean
    public FindPatientByNameUseCase findPatientByNameUseCase(
            FindPatientByNameOutputPort findPatientByNameOutputPort
    ) {
        return new FindPatientByNameUseCase(findPatientByNameOutputPort);
    }
}
