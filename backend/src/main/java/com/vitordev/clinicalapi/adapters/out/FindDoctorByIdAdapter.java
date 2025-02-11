package com.vitordev.clinicalapi.adapters.out;

import com.vitordev.clinicalapi.adapters.out.repository.DoctorRepository;
import com.vitordev.clinicalapi.adapters.out.repository.mapper.DoctorEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.out.FindDoctorByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindDoctorByIdAdapter implements FindDoctorByIdOutputPort {

    @Autowired
    private DoctorEntityMapper doctorEntityMapper;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Optional<Doctor> find(Long id) {
        var doctorEntity = doctorRepository.findById(id);
        return doctorEntity.map(x -> doctorEntityMapper.toDoctor(x));
    }
}
