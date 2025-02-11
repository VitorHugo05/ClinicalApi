package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindConsultationByPatientIdAdapter implements FindConsultationsByPatientIdOutputPort {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationEntityMapper consultationEntityMapper;

    @Override
    public List<Consultation> find(Long id) {
        List<ConsultationEntity> consultationEntities = consultationRepository
                .findByPatientId(id).orElseThrow(() -> new RuntimeException("Consultation not found"));
        return consultationEntities.stream()
                .map(x ->consultationEntityMapper.toConsultation(x)).toList();
    }
}
