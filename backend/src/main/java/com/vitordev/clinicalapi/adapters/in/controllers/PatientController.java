package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.PatientMapper;
import com.vitordev.clinicalapi.adapters.in.requests.PatientRequest;
import com.vitordev.clinicalapi.adapters.out.patient.FindPatientByIdAdapter;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.InsertPatientInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private InsertPatientInputPort insertPatientInputPort;

    @Autowired
    private FindPatientByIdInputPort findPatientByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PatientRequest patientRequest) {
        var patient = patientMapper.toPatient(patientRequest);
        insertPatientInputPort.insert(patient);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        var patient = findPatientByIdInputPort.find(id);
        return ResponseEntity.ok().body(patient);
    }
}
