package com.vitordev.clinicalapi.adapters.out.doctor;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.DoctorRepository;
import com.vitordev.clinicalapi.adapters.out.doctor.repository.mapper.DoctorEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.out.doctor.FindDoctorByEmailOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindDoctorByEmailAdapter implements FindDoctorByEmailOutputPort {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorEntityMapper doctorEntityMapper;

    @Override
    public List<Doctor> find(String email) {
        return doctorRepository.findByEmail(email).stream()
                .map(x -> doctorEntityMapper.toDoctor(x))
                .toList();
    }
}
