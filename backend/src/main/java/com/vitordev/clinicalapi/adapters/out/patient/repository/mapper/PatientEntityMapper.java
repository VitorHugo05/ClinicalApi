package com.vitordev.clinicalapi.adapters.out.patient.repository.mapper;

import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PatientEntityMapper {
    PatientEntity toPatientEntity(Patient patient);
}
