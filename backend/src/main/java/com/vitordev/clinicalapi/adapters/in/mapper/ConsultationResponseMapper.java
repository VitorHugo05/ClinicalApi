package com.vitordev.clinicalapi.adapters.in.mapper;

import com.vitordev.clinicalapi.adapters.in.response.ConsultationResponse;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class})
public interface ConsultationResponseMapper {
    @Mapping(source = "doctor", target = "doctor")
    @Mapping(source = "patient", target = "patient")
    @Mapping(source = "date", target = "date")
    ConsultationResponse toResponse(Consultation consultation);
}
