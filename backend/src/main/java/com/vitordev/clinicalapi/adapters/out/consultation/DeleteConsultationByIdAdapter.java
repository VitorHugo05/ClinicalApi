package com.vitordev.clinicalapi.adapters.out.consultation;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.ConsultationRepository;
import com.vitordev.clinicalapi.application.ports.out.consultation.DeleteConsultationByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteConsultationByIdAdapter implements DeleteConsultationByIdOutputPort {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public void delete(Long id) {
        consultationRepository.deleteById(id);
    }
}
