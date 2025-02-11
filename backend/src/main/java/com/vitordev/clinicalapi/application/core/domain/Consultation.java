package com.vitordev.clinicalapi.application.core.domain;

import java.util.Date;

public class Consultation {
    private Long id;
    private Doctor doctor;
    private Patient patient;
    private Date date;

    public Consultation() {}

    public Consultation(Long id, Doctor doctor, Patient patient, Date date) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
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
