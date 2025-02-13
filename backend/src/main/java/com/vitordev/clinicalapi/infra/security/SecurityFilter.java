package com.vitordev.clinicalapi.infra.security;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.DoctorRepository;
import com.vitordev.clinicalapi.adapters.out.patient.repository.PatientRepository;
import com.vitordev.clinicalapi.application.core.domain.exceptions.AccessDeniedException;
import com.vitordev.clinicalapi.application.core.domain.exceptions.ObjectNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoveryToken(request);
        if (token != null) {
            var subject = tokenService.verifyToken(token);
            if (subject != null && !subject.isEmpty()) {
                UserDetails user = null;
                user = doctorRepository.findById(Long.valueOf(subject))
                        .orElse(null);

                if (user == null) {
                    user = patientRepository.findById(Long.valueOf(subject))
                            .orElse(null);
                }

                if (user == null) {
                    throw new ObjectNotFoundException("User not found");
                }

                var userRole = user.getAuthorities().stream()
                        .findFirst()
                        .map(GrantedAuthority::getAuthority)
                        .orElseThrow(() -> new AccessDeniedException("User has no valid role"));

                if ("ROLE_DOCTOR".equals(userRole) || "ROLE_PATIENT".equals(userRole)) {
                    var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                } else {
                    throw new AccessDeniedException("Invalid user role");
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        if (!authHeader.startsWith("Bearer ")) {
            throw new AccessDeniedException("Authorization header must start with 'Bearer '");
        }
        return authHeader.replace("Bearer ", "");
    }
}