package com.vitordev.clinicalapi.adapters.out.patient;

import com.vitordev.clinicalapi.adapters.out.patient.repository.PatientRepository;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import com.vitordev.clinicalapi.adapters.out.patient.repository.mapper.PatientEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByNameOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindPatientByNameAdapter implements FindPatientByNameOutputPort {

    @Autowired
    private PatientEntityMapper patientEntityMapper;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<Patient> find(String name) {
        var patient = patientRepository.findByName(name);
        return patient.map(x -> patientEntityMapper.toPatient(x));
    }
}
