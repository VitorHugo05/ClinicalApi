package com.vitordev.clinicalapi.config.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.FindConsultationsByDoctorIdAndDateUseCase;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByDoctorIdAndDateOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindConsultationsByDoctorIdAndDateConfig {
    @Bean
    public FindConsultationsByDoctorIdAndDateUseCase findConsultationByDoctorIdAndDateUseCase(
            FindConsultationsByDoctorIdAndDateOutputPort findConsultationsByDoctorIdAndDateOutputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort
    ) {
        return new FindConsultationsByDoctorIdAndDateUseCase(findConsultationsByDoctorIdAndDateOutputPort, findDoctorByIdInputPort);
    }
}
