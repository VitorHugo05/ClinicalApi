package com.vitordev.clinicalapi.adapters.out;

import com.vitordev.clinicalapi.adapters.out.repository.DoctorRepository;
import com.vitordev.clinicalapi.adapters.out.repository.mapper.DoctorEntityMapping;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.out.FindDoctorByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindDoctorByIdAdapter implements FindDoctorByIdOutputPort {

    @Autowired
    private DoctorEntityMapping doctorEntityMapping;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Optional<Doctor> find(Long id) {
        var doctorEntity = doctorRepository.findById(id);
        return doctorEntity.map(x -> doctorEntityMapping.toDoctor(x));
    }
}
