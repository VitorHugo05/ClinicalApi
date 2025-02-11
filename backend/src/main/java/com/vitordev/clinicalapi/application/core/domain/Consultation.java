package com.vitordev.clinicalapi.application.core.domain;

import com.vitordev.clinicalapi.application.core.domain.enums.StatusConsultation;

import java.util.Date;

public class Consultation {
    private Long id;
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private StatusConsultation status;

    public Consultation() {}

    public Consultation(Long id, Doctor doctor, Patient patient, Date date, StatusConsultation status) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.status = status;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
