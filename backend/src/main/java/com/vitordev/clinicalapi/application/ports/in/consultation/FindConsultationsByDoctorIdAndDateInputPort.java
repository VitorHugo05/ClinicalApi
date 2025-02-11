package com.vitordev.clinicalapi.application.ports.in.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.time.LocalDate;
import java.util.List;

public interface FindConsultationsByDoctorIdAndDateInputPort {
    List<Consultation> find(Long doctorId, LocalDate date);
}
