package com.vitordev.clinicalapi.adapters.in.mapper;

import com.vitordev.clinicalapi.adapters.in.requests.DoctorRequest;

import com.vitordev.clinicalapi.application.core.domain.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    @Mapping(target = "id", ignore = true)
    Doctor toDoctor(DoctorRequest doctorRequest);
}
