package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.out.consultation.UpdateConsultationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateConsultationAdapter implements UpdateConsultationOutputPort {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationEntityMapper consultationEntityMapper;

    @Override
    public void update(Consultation consultation) {
        ConsultationEntity consultationEntity = consultationEntityMapper.toConsultationEntity(consultation);
        consultationRepository.save(consultationEntity);
    }
}
