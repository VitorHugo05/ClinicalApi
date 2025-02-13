package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FindConsultationByPatientIdAdapter implements FindConsultationsByPatientIdOutputPort {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationEntityMapper consultationEntityMapper;

    @Override
    public Optional<List<Consultation>> find(Long id) {
        return consultationRepository.findByPatientId(id)
                .map(consultationEntities -> consultationEntities.stream()
                        .map(consultationEntityMapper::toConsultation)
                        .toList());
    }
}
