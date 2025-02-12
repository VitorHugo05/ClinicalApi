package com.vitordev.clinicalapi.adapters.in.mapper;

import com.vitordev.clinicalapi.adapters.in.requests.ConsultationUpdateRequest;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsultationUpdateMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "patient", ignore = true)
    Consultation toConsultation(ConsultationUpdateRequest consultationUpdateRequest);
}
