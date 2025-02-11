package com.vitordev.clinicalapi.adapters.out;

import com.vitordev.clinicalapi.adapters.out.repository.DoctorRepository;
import com.vitordev.clinicalapi.adapters.out.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.adapters.out.repository.mapper.DoctorEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.out.InsertDoctorOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertDoctorAdapter implements InsertDoctorOutputPort {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorEntityMapper doctorEntityMapper;

    @Override
    public void insert(Doctor doctor) {
        DoctorEntity doctorEntity = doctorEntityMapper.toDoctorEntity(doctor);
        doctorRepository.save(doctorEntity);
    }
}
