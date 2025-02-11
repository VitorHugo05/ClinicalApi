package com.vitordev.clinicalapi.config;

import com.vitordev.clinicalapi.application.core.usecase.DeleteDoctorByIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.DeleteDoctorByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteDoctorByIdConfig {
    @Bean
    public DeleteDoctorByIdUseCase deleteDoctorByIdUseCase(
            FindDoctorByIdInputPort findDoctorByIdInputPort,
            DeleteDoctorByIdOutputPort deleteDoctorByIdOutputPort
    ) {
        return new DeleteDoctorByIdUseCase(findDoctorByIdInputPort, deleteDoctorByIdOutputPort);
    }
}
