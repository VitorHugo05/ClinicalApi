package com.vitordev.clinicalapi.application.ports.in;

import com.vitordev.clinicalapi.application.core.domain.Doctor;

public interface UpdateDoctorInputPort {
    void update(Doctor doctor);
}
