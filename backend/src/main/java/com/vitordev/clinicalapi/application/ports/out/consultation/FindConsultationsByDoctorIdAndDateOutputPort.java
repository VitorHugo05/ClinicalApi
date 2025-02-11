package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.time.LocalDate;
import java.util.List;

public interface FindConsultationsByDoctorIdAndDateOutputPort {
   List<Consultation> find(Long id, LocalDate date);
}
