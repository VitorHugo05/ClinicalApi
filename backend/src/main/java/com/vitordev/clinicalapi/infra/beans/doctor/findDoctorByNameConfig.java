package com.vitordev.clinicalapi.infra.beans.doctor;

import com.vitordev.clinicalapi.application.core.usecase.doctor.FindDoctorByNameUseCase;
import com.vitordev.clinicalapi.application.ports.out.doctor.FindDoctorByNameOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class findDoctorByNameConfig {
    @Bean
    public FindDoctorByNameUseCase findDoctorByNameUseCase(
            FindDoctorByNameOutputPort findDoctorByNameOutputPort
    ) {
        return new FindDoctorByNameUseCase(findDoctorByNameOutputPort);
    }
}
