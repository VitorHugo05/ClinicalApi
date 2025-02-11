package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.util.List;

public interface FindConsultationsByPatientIdOutputPort {
    List<Consultation> find(Long id);
}
