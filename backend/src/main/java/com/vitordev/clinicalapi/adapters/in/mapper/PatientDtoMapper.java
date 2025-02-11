package com.vitordev.clinicalapi.adapters.in.mapper;

import com.vitordev.clinicalapi.adapters.in.response.PatientDTO;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientDtoMapper {
    PatientDTO toDTO(Patient patient);
}
