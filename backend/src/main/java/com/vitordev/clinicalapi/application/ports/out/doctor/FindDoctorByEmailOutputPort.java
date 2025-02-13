package com.vitordev.clinicalapi.application.ports.out.doctor;

import com.vitordev.clinicalapi.application.core.domain.Doctor;

import java.util.Optional;

public interface FindDoctorByEmailOutputPort {
    Optional<Doctor> find(String email);
}
