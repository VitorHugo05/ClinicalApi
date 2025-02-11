package com.vitordev.clinicalapi.adapters.out.doctor.repository.mapper;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface DoctorEntityMapper {
    @Mapping(target = "consultations", ignore = true)
    DoctorEntity toDoctorEntity(Doctor doctor);
    Doctor toDoctor (DoctorEntity doctorEntity);
}
