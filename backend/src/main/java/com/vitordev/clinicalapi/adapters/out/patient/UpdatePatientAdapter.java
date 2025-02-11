package com.vitordev.clinicalapi.adapters.out.patient;

import com.vitordev.clinicalapi.adapters.out.patient.repository.PatientRepository;
import com.vitordev.clinicalapi.adapters.out.patient.repository.mapper.PatientEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.out.patient.UpdatePatientOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePatientAdapter implements UpdatePatientOutputPort {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientEntityMapper patientEntityMapper;

    @Override
    public void update(Patient patient) {
        var patientEntity = patientEntityMapper.toPatientEntity(patient);
        patientRepository.save(patientEntity);
    }
}
