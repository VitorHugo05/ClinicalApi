package com.vitordev.clinicalapi.adapters.in.mapper;

import com.vitordev.clinicalapi.adapters.in.requests.ConsultationRequest;
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

    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "status", ignore = true)
    Consultation toRequest(ConsultationRequest consultationRequest);
}
