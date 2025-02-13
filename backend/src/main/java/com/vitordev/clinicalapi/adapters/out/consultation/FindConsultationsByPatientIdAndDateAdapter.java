package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdAndDateOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class FindConsultationsByPatientIdAndDateAdapter implements FindConsultationsByPatientIdAndDateOutputPort {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationEntityMapper consultationEntityMapper;

    @Override
    public Optional<List<Consultation>> find(Long id, LocalDate date) {
       return consultationRepository.findByPatientIdAndDateEquals(id, date)
                .map(consultationEntities -> consultationEntities.stream()
                        .map(consultationEntityMapper::toConsultation)
                        .toList());
    }
}
