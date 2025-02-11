package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.ConsultationResponseMapper;
import com.vitordev.clinicalapi.adapters.in.response.ConsultationResponse;
import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {
    @Autowired
    private FindConsultationsByDoctorIdInputPort findConsultationsByDoctorIdInputPort;
    @Autowired
    private ConsultationResponseMapper consultationResponseMapper;

    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<ConsultationResponse>> find(@PathVariable Long id) {
        List<Consultation> consultationList = findConsultationsByDoctorIdInputPort.find(id);
        List<ConsultationResponse> consultationResponses = consultationList.stream().map(x -> consultationResponseMapper.toResponse(x)).toList();
        return ResponseEntity.ok(consultationResponses);
    }
}
