package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.ConsultationResponseMapper;
import com.vitordev.clinicalapi.adapters.in.response.ConsultationResponse;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdAndDateInputPort;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByPatientIdInputPort;
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
    private ConsultationResponseMapper consultationResponseMapper;

    @Autowired
    private FindConsultationsByDoctorIdInputPort findConsultationsByDoctorIdInputPort;

    @Autowired
    private FindConsultationsByPatientIdInputPort findConsultationsByPatientIdInputPort;

    @Autowired
    private FindConsultationsByDoctorIdAndDateInputPort findConsultationsByDoctorIdAndDateInputPort;

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
    public ResponseEntity<List<ConsultationResponse>> findByDoctorId(@PathVariable Long id, @RequestParam("date") String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Consultation> consultationList = findConsultationsByDoctorIdAndDateInputPort.find(id, localDate);
        List<ConsultationResponse> consultationResponseList = consultationList.stream()
                .map(x -> consultationResponseMapper.toResponse(x)).toList();
        return ResponseEntity.ok(consultationResponseList);
    }
}
