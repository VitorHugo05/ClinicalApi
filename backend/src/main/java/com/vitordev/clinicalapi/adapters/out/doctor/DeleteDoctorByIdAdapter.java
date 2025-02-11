package com.vitordev.clinicalapi.adapters.out.doctor;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.DoctorRepository;
import com.vitordev.clinicalapi.application.ports.out.doctor.DeleteDoctorByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDoctorByIdAdapter implements DeleteDoctorByIdOutputPort {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
