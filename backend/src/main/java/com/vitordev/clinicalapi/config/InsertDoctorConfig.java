package com.vitordev.clinicalapi.config;

import com.vitordev.clinicalapi.application.core.usecase.InsertDoctorUseCase;
import com.vitordev.clinicalapi.application.ports.in.InsertDoctorInputPort;
import com.vitordev.clinicalapi.application.ports.out.InsertDoctorOutputPort;
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
