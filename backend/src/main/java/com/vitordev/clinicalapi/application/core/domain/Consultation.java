package com.vitordev.clinicalapi.application.core.domain;

import com.vitordev.clinicalapi.application.core.domain.enums.StatusConsultation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consultation {
    private Long id;
    private Doctor doctor;
    private Patient patient;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDate date;

    private StatusConsultation status;

    public Consultation() {}

    public Consultation(Long id, Doctor doctor, Patient patient, LocalDateTime startAt, LocalDateTime endAt, LocalDate date, StatusConsultation status) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.startAt = startAt;
        this.endAt = endAt;
        this.date = date;
        this.status = status;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalDateTime endAt) {
        this.endAt = endAt;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StatusConsultation getStatus() {
        return status;
    }

    public void setStatus(StatusConsultation status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
