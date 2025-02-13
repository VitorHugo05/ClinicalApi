package com.vitordev.clinicalapi.infra.beans.consultation;

import com.vitordev.clinicalapi.application.core.usecase.consultation.InsertConsultationUseCase;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdAndDateInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.InsertConsultationOutputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.InsertDoctorOutputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.InsertPatientOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertConsultationConfig {
    @Bean
    public InsertConsultationUseCase insertConsultationUseCase(
            InsertConsultationOutputPort insertConsultationOutputPort,
            FindConsultationsByDoctorIdAndDateInputPort findConsultationsByDoctorIdAndDateInputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort,
            FindPatientByIdInputPort findPatientByIdInputPort,
            InsertPatientOutputPort insertPatientOutputPort,
            InsertDoctorOutputPort insertDoctorOutputPort
    ) {
        return new InsertConsultationUseCase(
                insertConsultationOutputPort,
                findConsultationsByDoctorIdAndDateInputPort,
                findDoctorByIdInputPort,
                findPatientByIdInputPort,
                insertPatientOutputPort,
                insertDoctorOutputPort
        );
    }
}
