package com.vitordev.clinicalapi.adapters.out.repository.mapper;

import com.vitordev.clinicalapi.adapters.out.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DoctorEntityMapping {
    DoctorEntity toDoctorEntity(Doctor doctor);
    Doctor toDoctor (DoctorEntity doctorEntity);
}
