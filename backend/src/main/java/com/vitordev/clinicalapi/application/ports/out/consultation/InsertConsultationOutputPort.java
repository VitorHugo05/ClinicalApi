package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

public interface InsertConsultationOutputPort {
    void insert(Consultation consultation);
}
