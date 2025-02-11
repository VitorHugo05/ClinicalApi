package com.vitordev.clinicalapi.config;

import com.vitordev.clinicalapi.application.core.usecase.UpdateDoctorUseCase;
import com.vitordev.clinicalapi.application.ports.in.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.UpdateDoctorOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateDoctorConfig {
    @Bean
    public UpdateDoctorUseCase updateDoctorUseCase(
            UpdateDoctorOutputPort updateDoctorOutputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort
    ) {
        return new UpdateDoctorUseCase(updateDoctorOutputPort, findDoctorByIdInputPort);
    }
}
