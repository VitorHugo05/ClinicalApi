package com.vitordev.clinicalapi.application.ports.in.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.util.List;

public interface FindConsultationsByPatientIdInputPort {
    List<Consultation> find(Long id);
}
