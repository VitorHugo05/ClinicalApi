package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.out.consultation.FindConsultationsByPatientIdAndDateOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class FindConsultationsByPatientIdAndDateAdapter implements FindConsultationsByPatientIdAndDateOutputPort {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ConsultationEntityMapper consultationEntityMapper;

    @Override
    public List<Consultation> find(Long id, LocalDate date) {
        List<ConsultationEntity> consultationEntityList = consultationRepository.findByPatientIdAndDateEquals(id, date)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));
        return consultationEntityList.stream()
                .map(x -> consultationEntityMapper.toConsultation(x))
                .toList();
    }
}
