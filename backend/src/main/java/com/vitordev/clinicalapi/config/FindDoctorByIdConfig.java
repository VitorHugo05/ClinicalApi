package com.vitordev.clinicalapi.config;

import com.vitordev.clinicalapi.application.core.usecase.FindDoctorByIdUseCase;
import com.vitordev.clinicalapi.application.ports.out.FindDoctorByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindDoctorByIdConfig {
    @Bean
    public FindDoctorByIdUseCase findDoctorByIdUseCase(
            FindDoctorByIdOutputPort findDoctorByIdOutputPort
    ) {
        return new FindDoctorByIdUseCase(findDoctorByIdOutputPort);
    }
}
