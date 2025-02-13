package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.DoctorMapper;
import com.vitordev.clinicalapi.adapters.in.requests.DoctorRequest;
import com.vitordev.clinicalapi.adapters.in.response.AuthResponse;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.in.doctor.InsertDoctorInputPort;
import com.vitordev.clinicalapi.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private InsertDoctorInputPort insertDoctorInputPort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register/doctor")
    public ResponseEntity<AuthResponse> insertDoctor(@RequestBody @Valid DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.toDoctor(doctorRequest);
        doctor.setPassword(passwordEncoder.encode(doctorRequest.getPassword()));
        Doctor doctorResponse = insertDoctorInputPort.insert(doctor);
        var token = tokenService.generateDoctorToken(doctorMapper.toDoctorEntity(doctorResponse));
        return ResponseEntity.ok().body(new AuthResponse(token));
    }
}
