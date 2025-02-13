package com.vitordev.clinicalapi.adapters.out.patient;

import com.vitordev.clinicalapi.adapters.out.patient.repository.PatientRepository;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByEmailOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindPatientByEmailAdapter implements FindPatientByEmailOutputPort {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<PatientEntity> find(String email) {
        return patientRepository.findByEmail(email);
    }
}
