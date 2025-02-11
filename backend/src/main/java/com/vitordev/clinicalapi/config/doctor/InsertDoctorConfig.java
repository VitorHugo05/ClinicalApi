package com.vitordev.clinicalapi.config.doctor;

import com.vitordev.clinicalapi.application.core.usecase.doctor.InsertDoctorUseCase;
import com.vitordev.clinicalapi.application.ports.out.doctor.InsertDoctorOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertDoctorConfig {
    @Bean
    public InsertDoctorUseCase insertDoctorUseCase(
            InsertDoctorOutputPort insertDoctorOutputPort
    ) {
        return new InsertDoctorUseCase(insertDoctorOutputPort);
    }
}
