package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.core.usecase.patient.FindPatientByIdUseCase;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByPatientIdAndDateInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdAndDateOutputPort;

import java.time.LocalDate;
import java.util.List;

public class FindConsultationsByPatientIdAndDateUseCase implements FindConsultationsByPatientIdAndDateInputPort {
    private final FindConsultationsByPatientIdAndDateOutputPort findConsultationsByPatientIdAndDateOutputPort;
    private final FindPatientByIdUseCase findPatientByIdUseCase;

    public FindConsultationsByPatientIdAndDateUseCase(
            FindConsultationsByPatientIdAndDateOutputPort findConsultationsByPatientIdAndDateOutputPort,
            FindPatientByIdUseCase findPatientByIdUseCase
    ) {
        this.findConsultationsByPatientIdAndDateOutputPort = findConsultationsByPatientIdAndDateOutputPort;
        this.findPatientByIdUseCase = findPatientByIdUseCase;
    }

    @Override
    public List<Consultation> find(Long id, LocalDate date) {
        findPatientByIdUseCase.find(id);
        return findConsultationsByPatientIdAndDateOutputPort.find(id, date)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
}
