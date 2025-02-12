package com.vitordev.clinicalapi.application.ports.in.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

public interface FindConsultationByIdInputPort {
    Consultation find(Long id);
}
