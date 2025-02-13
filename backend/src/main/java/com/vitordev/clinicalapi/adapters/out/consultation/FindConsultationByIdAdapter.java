package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindConsultationByIdAdapter implements FindConsultationByIdOutputPort {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationEntityMapper consultationEntityMapper;

    @Override
    public Optional<Consultation> find(Long id) {
        var consultationEntity = consultationRepository.findById(id);

        return consultationEntity.map(x -> consultationEntityMapper.toConsultation(x));
    }
}
