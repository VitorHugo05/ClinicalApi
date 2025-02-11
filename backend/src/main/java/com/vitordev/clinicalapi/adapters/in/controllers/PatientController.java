package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.PatientMapper;
import com.vitordev.clinicalapi.adapters.in.requests.PatientRequest;
import com.vitordev.clinicalapi.application.ports.in.patient.InsertPatientInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private InsertPatientInputPort insertPatientInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PatientRequest patientRequest) {
        var patient = patientMapper.toPatient(patientRequest);
        insertPatientInputPort.insert(patient);
        return ResponseEntity.ok().build();
    }
}
