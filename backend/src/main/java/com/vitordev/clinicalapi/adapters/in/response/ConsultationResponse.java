package com.vitordev.clinicalapi.adapters.in.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vitordev.clinicalapi.application.core.domain.enums.StatusConsultation;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultationResponse {
    private Long id;
    private DoctorDTO doctor;
    private PatientDTO patient;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startAt;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    private StatusConsultation status;
}
