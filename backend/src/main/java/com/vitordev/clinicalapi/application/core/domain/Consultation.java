package com.vitordev.clinicalapi.application.core.domain;

import com.vitordev.clinicalapi.application.core.domain.enums.StatusConsultation;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation {
    private Long id;
    private Doctor doctor;
    private Patient patient;

    private LocalTime startAt;
    private LocalTime endAt;
    private LocalDate date;

    private StatusConsultation status;

    public Consultation() {}

    public Consultation(Long id, StatusConsultation status, LocalDate date, LocalTime endAt, LocalTime startAt, Patient patient, Doctor doctor) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.endAt = endAt;
        this.startAt = startAt;
        this.patient = patient;
        this.doctor = doctor;
    }

    public LocalTime getEndAt() {
        return endAt;
    }

    public void setEndAt(LocalTime endAt) {
        this.endAt = endAt;
    }

    public LocalTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalTime startAt) {
        this.startAt = startAt;
    }

    public LocalDate getDate() {
        return date;
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
