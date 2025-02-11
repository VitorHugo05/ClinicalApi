package com.vitordev.clinicalapi.application.ports.out;

import com.vitordev.clinicalapi.application.core.domain.Doctor;

import java.util.Optional;

public interface FindDoctorByIdOutputPort {
    Optional<Doctor> find(Long id);
}
