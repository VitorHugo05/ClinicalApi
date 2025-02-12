package com.vitordev.clinicalapi.application.ports.in.doctor;

import com.vitordev.clinicalapi.application.core.domain.Doctor;

public interface FindDoctorByNameInputPort {
    Doctor find(String name);
}
