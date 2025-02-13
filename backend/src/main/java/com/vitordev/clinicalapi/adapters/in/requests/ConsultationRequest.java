package com.vitordev.clinicalapi.adapters.in.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vitordev.clinicalapi.application.core.domain.enums.StatusConsultation;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultationRequest {
    @NotBlank
    private DoctorRequest doctor;

    @NotBlank
    private PatientRequest patient;

    @NotBlank
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startAt;

    @NotBlank
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endAt;

    @NotBlank
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    private StatusConsultation status;
}
