package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.util.List;
import java.util.Optional;

public interface FindConsultationsByPatientIdOutputPort {
    Optional<List<Consultation>> find(Long id);
}
