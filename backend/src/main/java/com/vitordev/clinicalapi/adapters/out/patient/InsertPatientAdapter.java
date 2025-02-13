package com.vitordev.clinicalapi.adapters.out.patient;

import com.vitordev.clinicalapi.adapters.out.patient.repository.PatientRepository;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import com.vitordev.clinicalapi.adapters.out.patient.repository.mapper.PatientEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.out.patient.InsertPatientOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertPatientAdapter implements InsertPatientOutputPort {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientEntityMapper patientEntityMapper;

    @Override
    public Patient insert(Patient patient) {
        PatientEntity patientEntity = patientEntityMapper.toPatientEntity(patient);
        var patientResponse = patientRepository.save(patientEntity);
        return patientEntityMapper.toPatient(patientResponse);
    }
}
