package com.vitordev.clinicalapi.infra.beans.doctor;

import com.vitordev.clinicalapi.application.core.usecase.doctor.DeleteDoctorByIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.DeleteDoctorByIdOutputPort;
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
