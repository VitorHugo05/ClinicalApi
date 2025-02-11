package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByDoctorIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FindConsultationByDoctorIdAdapter implements FindConsultationsByDoctorIdOutputPort {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationEntityMapper consultationEntityMapper;

    @Override
    public List<Consultation> find(Long id) {
        List<ConsultationEntity> consultationEntities = consultationRepository.findByDoctorId(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        return consultationEntities.stream()
                .map(consultationEntityMapper::toConsultation)
                .collect(Collectors.toList());
    }
}
