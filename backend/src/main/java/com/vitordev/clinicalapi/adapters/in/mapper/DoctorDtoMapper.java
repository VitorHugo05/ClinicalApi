package com.vitordev.clinicalapi.adapters.in.mapper;

import com.vitordev.clinicalapi.adapters.in.response.DoctorDTO;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorDtoMapper {
    DoctorDTO toDTO(Doctor doctor);
}
