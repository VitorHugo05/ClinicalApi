package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

public interface FindConsultationByIdOutputPort {
    Consultation find(Long id);
}
