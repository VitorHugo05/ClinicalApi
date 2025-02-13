package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdAndDateInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByDoctorIdAndDateOutputPort;

import java.time.LocalDate;
import java.util.List;

public class FindConsultationsByDoctorIdAndDateUseCase implements FindConsultationsByDoctorIdAndDateInputPort {
    private final FindConsultationsByDoctorIdAndDateOutputPort findConsultationsByDoctorIdAndDateOutputPort;
    private final FindDoctorByIdInputPort findDoctorByIdInputPort;

    public FindConsultationsByDoctorIdAndDateUseCase(
            FindConsultationsByDoctorIdAndDateOutputPort findConsultationsByDoctorIdAndDateOutputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort
    ) {
        this.findConsultationsByDoctorIdAndDateOutputPort = findConsultationsByDoctorIdAndDateOutputPort;
        this.findDoctorByIdInputPort = findDoctorByIdInputPort;
    }

    @Override
    public List<Consultation> find(Long id, LocalDate date) {
        findDoctorByIdInputPort.find(id);
        return findConsultationsByDoctorIdAndDateOutputPort.find(id, date)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
}
