package com.vitordev.clinicalapi.infra.security;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.DoctorRepository;
import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.adapters.out.patient.repository.PatientRepository;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public CustomUserDetailsService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<DoctorEntity> doctor = doctorRepository.findByEmail(email);
        if (doctor.isPresent()) {
            return doctor.get();
        }

        Optional<PatientEntity> patient = patientRepository.findByEmail(email);
        if (patient.isPresent()) {
            return patient.get();
        }

        throw new UsernameNotFoundException("User not found");
    }
}
