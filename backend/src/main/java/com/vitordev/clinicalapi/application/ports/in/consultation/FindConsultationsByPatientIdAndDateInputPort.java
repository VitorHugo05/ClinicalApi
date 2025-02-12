package com.vitordev.clinicalapi.application.ports.in.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.time.LocalDate;
import java.util.List;

public interface FindConsultationsByPatientIdAndDateInputPort {
    List<Consultation> find(Long id, LocalDate date);
}
