package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.out.consultation.InsertConsultationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertConsultationAdapter implements InsertConsultationOutputPort {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationEntityMapper consultationEntityMapper;

    @Override
    public void insert(Consultation consultation) {
        ConsultationEntity consultationEntity = consultationEntityMapper.toConsultationEntity(consultation);
        consultationRepository.save(consultationEntity);
    }
}
