package com.vitordev.clinicalapi.config.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.FindConsultationByDoctorIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByDoctorIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindConsultationsByDoctorIdConfig {
    @Bean
    public FindConsultationByDoctorIdUseCase findConsultationByDoctorIdUseCase(
            FindConsultationsByDoctorIdOutputPort findConsultationsByDoctorIdOutputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort
    ) {
        return new FindConsultationByDoctorIdUseCase(findConsultationsByDoctorIdOutputPort, findDoctorByIdInputPort);
    }
}
