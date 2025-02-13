package com.vitordev.clinicalapi.application.ports.out.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FindConsultationsByDoctorIdAndDateOutputPort {
   Optional<List<Consultation>> find(Long id, LocalDate date);
}
