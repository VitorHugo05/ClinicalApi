package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.PatientDtoMapper;
import com.vitordev.clinicalapi.adapters.in.mapper.PatientMapper;
import com.vitordev.clinicalapi.adapters.in.requests.PatientRequest;
import com.vitordev.clinicalapi.adapters.in.response.PatientDTO;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.in.patient.DeletePatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.InsertPatientInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.UpdatePatientInputPort;
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

    @Autowired
    private UpdatePatientInputPort updatePatientInputPort;

    @Autowired
    private DeletePatientByIdInputPort deletePatientByIdInputPort;

    @Autowired
    private PatientDtoMapper patientDtoMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody PatientRequest patientRequest) {
        var patient = patientMapper.toPatient(patientRequest);
        insertPatientInputPort.insert(patient);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id) {
        var patient = findPatientByIdInputPort.find(id);
        return ResponseEntity.ok().body(patientDtoMapper.toDTO(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PatientRequest patientRequest) {
        var patient = patientMapper.toPatient(patientRequest);
        patient.setId(id);
        updatePatientInputPort.update(patient);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePatientByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
