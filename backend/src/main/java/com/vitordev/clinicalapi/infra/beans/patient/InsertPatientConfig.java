package com.vitordev.clinicalapi.infra.beans.patient;

import com.vitordev.clinicalapi.application.core.usecase.patient.InsertPatientUseCase;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByEmailOutputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.InsertPatientOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertPatientConfig {
    @Bean
    public InsertPatientUseCase insertPatientUseCase(
            InsertPatientOutputPort insertPatientOutputPort,
            FindPatientByEmailOutputPort findPatientByEmailOutputPort
    ) {
        return new InsertPatientUseCase(insertPatientOutputPort, findPatientByEmailOutputPort);
    }
}
