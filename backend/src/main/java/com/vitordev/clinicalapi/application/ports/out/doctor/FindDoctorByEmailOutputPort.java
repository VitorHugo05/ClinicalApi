package com.vitordev.clinicalapi.application.ports.out.doctor;

import com.vitordev.clinicalapi.application.core.domain.Doctor;

import java.util.List;

public interface FindDoctorByEmailOutputPort {
    List<Doctor> find(String email);
}
