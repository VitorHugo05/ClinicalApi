package com.vitordev.clinicalapi.application.ports.out.doctor;

import com.vitordev.clinicalapi.application.core.domain.Doctor;

public interface UpdateDoctorOutputPort {
    void update(Doctor doctor);
}
