package com.vitordev.clinicalapi.adapters.out.patient;

import com.vitordev.clinicalapi.adapters.out.patient.repository.PatientRepository;
import com.vitordev.clinicalapi.adapters.out.patient.repository.mapper.PatientEntityMapper;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.out.patient.FindPatientByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindPatientByIdAdapter implements FindPatientByIdOutputPort {

    @Autowired
    private PatientEntityMapper patientEntityMapper;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<Patient> find(Long id) {
        var patient = patientRepository.findById(id);
        return patient.map(x -> patientEntityMapper.toPatient(x));
    }
}
