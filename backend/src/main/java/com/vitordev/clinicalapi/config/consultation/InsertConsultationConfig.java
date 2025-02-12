package com.vitordev.clinicalapi.config.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.InsertConsultationUseCase;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdAndDateInputPort;
import com.vitordev.clinicalapi.application.ports.in.consultation.InsertConsultationInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.InsertConsultationOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertConsultationConfig {
    @Bean
    public InsertConsultationUseCase insertConsultationUseCase(
            InsertConsultationOutputPort insertConsultationOutputPort,
            FindConsultationsByDoctorIdAndDateInputPort findConsultationsByDoctorIdAndDateInputPort
    ) {
        return new InsertConsultationUseCase(insertConsultationOutputPort, findConsultationsByDoctorIdAndDateInputPort);
    }
}
