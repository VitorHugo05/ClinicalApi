package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

public interface UpdateConsultationOutputPort {
    void update(Consultation consultation);
}
