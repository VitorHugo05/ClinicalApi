package com.vitordev.clinicalapi.adapters.out.patient;

import com.vitordev.clinicalapi.adapters.out.patient.repository.PatientRepository;
import com.vitordev.clinicalapi.application.ports.out.patient.DeletePatientByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePatientByIdAdapter implements DeletePatientByIdOutputPort {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }
}
