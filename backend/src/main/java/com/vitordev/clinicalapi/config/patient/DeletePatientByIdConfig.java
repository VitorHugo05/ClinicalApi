package com.vitordev.clinicalapi.config.patient;

import com.vitordev.clinicalapi.application.core.usecase.patient.DeletePatientByIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.DeletePatientByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletePatientByIdConfig {
    @Bean
    public DeletePatientByIdUseCase deletePatientByIdUseCase(
            DeletePatientByIdOutputPort deletePatientByIdOutputPort,
            FindPatientByIdInputPort findPatientByIdInputPort
    ) {
        return new DeletePatientByIdUseCase(deletePatientByIdOutputPort, findPatientByIdInputPort);
    }
}
