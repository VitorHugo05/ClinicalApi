package com.vitordev.clinicalapi.adapters.in.mapper;

import com.vitordev.clinicalapi.adapters.in.requests.PatientRequest;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ConsultationEntityMapper.class})
public interface PatientMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultations", ignore = true)
    Patient toPatient(PatientRequest patientRequest);

    @Mapping(source = "consultations", target = "consultations")
    @Mapping(target = "userRole", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    PatientEntity toPatientEntity(Patient patient);
}

