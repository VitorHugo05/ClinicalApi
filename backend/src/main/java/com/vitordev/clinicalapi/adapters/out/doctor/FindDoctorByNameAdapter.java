package com.vitordev.clinicalapi.adapters.out.doctor;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.DoctorRepository;
import com.vitordev.clinicalapi.adapters.out.doctor.repository.mapper.DoctorEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.out.doctor.FindDoctorByNameOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindDoctorByNameAdapter implements FindDoctorByNameOutputPort {

    @Autowired
    private DoctorEntityMapper doctorEntityMapper;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Optional<Doctor> find(String name) {
        var doctorEntity = doctorRepository.findByName(name);
        return doctorEntity.map(x -> doctorEntityMapper.toDoctor(x));
    }
}
