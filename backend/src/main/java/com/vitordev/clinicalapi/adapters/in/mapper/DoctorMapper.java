package com.vitordev.clinicalapi.adapters.in.mapper;

import com.vitordev.clinicalapi.adapters.in.requests.DoctorRequest;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.mapper.ConsultationEntityMapper;
import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ConsultationEntityMapper.class})
public interface DoctorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultations", ignore = true)
    Doctor toDoctor(DoctorRequest doctorRequest);

    @Mapping(target = "userRole", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(source = "id", target = "id")
    @Mapping(source = "consultations", target = "consultations")
    DoctorEntity toDoctorEntity(Doctor doctor);
}


