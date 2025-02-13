package com.vitordev.clinicalapi.adapters.out.patient.repository.mapper;

import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientEntityMapper {
    @Mapping(target = "userRole", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "consultations", ignore = true)
    PatientEntity toPatientEntity(Patient patient);

    @Mapping(target = "consultations", ignore = true)
    Patient toPatient(PatientEntity patientEntity);
}

