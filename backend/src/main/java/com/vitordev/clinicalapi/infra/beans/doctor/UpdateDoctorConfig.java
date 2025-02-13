package com.vitordev.clinicalapi.infra.beans.doctor;

import com.vitordev.clinicalapi.application.core.usecase.doctor.UpdateDoctorUseCase;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.UpdateDoctorOutputPort;
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
