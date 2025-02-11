package com.vitordev.clinicalapi.adapters.out.doctor.repository.mapper;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface DoctorEntityMapper {
    DoctorEntity toDoctorEntity(Doctor doctor);
    Doctor toDoctor (DoctorEntity doctorEntity);
}
