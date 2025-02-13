package com.vitordev.clinicalapi.infra.beans.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.FindConsultationsByDoctorIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByDoctorIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindConsultationsByDoctorIdConfig {
    @Bean
    public FindConsultationsByDoctorIdUseCase findConsultationByDoctorIdUseCase(
            FindConsultationsByDoctorIdOutputPort findConsultationsByDoctorIdOutputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort
    ) {
        return new FindConsultationsByDoctorIdUseCase(findConsultationsByDoctorIdOutputPort, findDoctorByIdInputPort);
    }
}
