package com.vitordev.clinicalapi.infra.beans.doctor;

import com.vitordev.clinicalapi.application.core.usecase.doctor.FindDoctorByIdUseCase;
import com.vitordev.clinicalapi.application.ports.out.doctor.FindDoctorByIdOutputPort;
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
