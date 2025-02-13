package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.util.Optional;

public interface FindConsultationByIdOutputPort {
    Optional<Consultation> find(Long id);
}
