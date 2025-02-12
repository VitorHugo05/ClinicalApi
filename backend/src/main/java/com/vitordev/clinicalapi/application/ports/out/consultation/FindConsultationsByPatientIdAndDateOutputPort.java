package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.time.LocalDate;
import java.util.List;

public interface FindConsultationsByPatientIdAndDateOutputPort {
    List<Consultation> find(Long id, LocalDate date);
}
