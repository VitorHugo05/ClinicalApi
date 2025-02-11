package com.vitordev.clinicalapi.config.patient;

import com.vitordev.clinicalapi.application.core.usecase.patient.UpdatePatientUseCase;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.UpdatePatientOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdatePatientConfig {
    @Bean
    public UpdatePatientUseCase updatePatientUseCase(
            UpdatePatientOutputPort updatePatientOutputPort,
            FindPatientByIdInputPort findPatientByIdInputPort
    ) {
        return new UpdatePatientUseCase(updatePatientOutputPort, findPatientByIdInputPort);
    }
}
