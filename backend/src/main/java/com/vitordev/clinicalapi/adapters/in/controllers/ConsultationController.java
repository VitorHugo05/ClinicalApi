package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.ConsultationResponseMapper;
import com.vitordev.clinicalapi.adapters.in.requests.ConsultationRequest;
import com.vitordev.clinicalapi.adapters.in.response.ConsultationResponse;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.core.domain.enums.StatusConsultation;
import com.vitordev.clinicalapi.application.ports.in.consultation.*;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByNameInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByNameInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Autowired
    private FindPatientByNameInputPort findPatientByNameInputPort;

    @Autowired
    private FindDoctorByNameInputPort findDoctorByNameInputPort;

    @Autowired
    private ConsultationResponseMapper consultationResponseMapper;

    @Autowired
    private InsertConsultationInputPort insertConsultationInputPort;

    @Autowired
    private DeleteConsultationByIdInputPort deleteConsultationByIdInputPort;

    @Autowired
    private FindConsultationByIdInputPort findConsultationByIdInputPort;

    @Autowired
    private FindConsultationsByDoctorIdInputPort findConsultationsByDoctorIdInputPort;

    @Autowired
    private FindConsultationsByPatientIdInputPort findConsultationsByPatientIdInputPort;

    @Autowired
    private FindConsultationsByDoctorIdAndDateInputPort findConsultationsByDoctorIdAndDateInputPort;

    @Autowired
    private FindConsultationsByPatientIdAndDateInputPort findConsultationsByPatientIdAndDateInputPort;

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<ConsultationResponse>> findByDoctor(@PathVariable Long id) {
        List<Consultation> consultationList = findConsultationsByDoctorIdInputPort.find(id);
        List<ConsultationResponse> consultationResponseList = consultationList.stream()
                .map(x -> consultationResponseMapper.toResponse(x)).toList();
        return ResponseEntity.ok(consultationResponseList);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<ConsultationResponse>> findByPatient(@PathVariable Long id) {
        List<Consultation> consultationList = findConsultationsByPatientIdInputPort.find(id);
        List<ConsultationResponse> consultationResponseList = consultationList.stream()
                .map(x -> consultationResponseMapper.toResponse(x)).toList();
        return ResponseEntity.ok(consultationResponseList);
    }

    @GetMapping("/doctor/{id}/date")
    public ResponseEntity<List<ConsultationResponse>> findByDoctorIdAndDate(@PathVariable Long id, @RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Consultation> consultationList = findConsultationsByDoctorIdAndDateInputPort.find(id, localDate);
        List<ConsultationResponse> consultationResponseList = consultationList.stream()
                .map(x -> consultationResponseMapper.toResponse(x)).toList();
        return ResponseEntity.ok(consultationResponseList);
    }

    @GetMapping("/patient/{id}/date")
    public ResponseEntity<List<ConsultationResponse>> findByPatientIdAndDate(@PathVariable Long id, @RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Consultation> consultationList = findConsultationsByPatientIdAndDateInputPort.find(id, localDate);
        List<ConsultationResponse> consultationResponseList = consultationList.stream()
                .map(x -> consultationResponseMapper.toResponse(x)).toList();
        return ResponseEntity.ok(consultationResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultationResponse> findById(@PathVariable Long id) {
        Consultation consultation = findConsultationByIdInputPort.find(id);
        ConsultationResponse consultationResponse = consultationResponseMapper.toResponse(consultation);
        return ResponseEntity.ok(consultationResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteConsultationByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ConsultationRequest consultationRequest) {
        Consultation consultation = consultationResponseMapper.toRequest(consultationRequest);

        Doctor doctor = findDoctorByNameInputPort.find(consultationRequest.getDoctor().getName());
        Patient patient = findPatientByNameInputPort.find(consultationRequest.getPatient().getName());

        consultation.setStatus(StatusConsultation.APPOINTMENT);
        consultation.setDoctor(doctor);
        consultation.setPatient(patient);

        insertConsultationInputPort.insert(consultation);
        return ResponseEntity.status(201).build();
    }
}
