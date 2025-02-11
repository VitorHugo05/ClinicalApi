package com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsultationEntityMapper {

    @Mapping(source = "doctor", target = "doctor")
    @Mapping(source = "patient", target = "patient")
    @Mapping(source = "date", target = "date")
    Consultation toConsultation(ConsultationEntity consultationEntity);

    ConsultationEntity toConsultationEntity(Consultation consultation);
}
