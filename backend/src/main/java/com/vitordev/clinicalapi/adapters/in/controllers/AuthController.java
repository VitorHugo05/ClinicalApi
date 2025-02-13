package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.DoctorMapper;
import com.vitordev.clinicalapi.adapters.in.mapper.PatientMapper;
import com.vitordev.clinicalapi.adapters.in.requests.AuthRequest;
import com.vitordev.clinicalapi.adapters.in.requests.DoctorRequest;
import com.vitordev.clinicalapi.adapters.in.requests.PatientRequest;
import com.vitordev.clinicalapi.adapters.in.response.AuthResponse;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.core.domain.exceptions.AccessDeniedException;
import com.vitordev.clinicalapi.application.core.domain.exceptions.ObjectNotFoundException;
import com.vitordev.clinicalapi.application.ports.in.doctor.InsertDoctorInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.InsertPatientInputPort;
import com.vitordev.clinicalapi.infra.security.TokenService;
import com.vitordev.clinicalapi.infra.security.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private PatientMapper patientMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private InsertPatientInputPort insertPatientInputPort;

    @PostMapping("/register/doctor")
    public ResponseEntity<AuthResponse> insertDoctor(@RequestBody @Valid DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.toDoctor(doctorRequest);
        doctor.setPassword(passwordEncoder.encode(doctorRequest.getPassword()));
        Doctor doctorResponse = insertDoctorInputPort.insert(doctor);
        var token = tokenService.generateToken(doctorMapper.toDoctorEntity(doctorResponse));
        return ResponseEntity.ok().body(new AuthResponse(token));
    }

    @PostMapping("/register/patient")
    public ResponseEntity<AuthResponse> insertPatient(@RequestBody @Valid PatientRequest patientRequest) {
        Patient patient = patientMapper.toPatient(patientRequest);
        patient.setPassword(passwordEncoder.encode(patientRequest.getPassword()));
        Patient patientResponse = insertPatientInputPort.insert(patient);
        var token = tokenService.generateToken(patientMapper.toPatientEntity(patientResponse));
        return ResponseEntity.ok().body(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthRequest authRequest) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
            var auth = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((UserEntity) auth.getPrincipal());
            return ResponseEntity.ok().body(new AuthResponse(token));
        }  catch (BadCredentialsException e) {
            throw new AccessDeniedException("Invalid credentials");
        } catch (UsernameNotFoundException e) {
            throw new ObjectNotFoundException("User not found");
        }
    }
}
