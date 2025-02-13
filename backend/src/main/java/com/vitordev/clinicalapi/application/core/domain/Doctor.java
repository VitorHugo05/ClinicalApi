package com.vitordev.clinicalapi.application.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String specialty;
    private List<Consultation> consultations = new ArrayList<>();

    public Doctor() {}

    public Doctor(Long id, String name, String email, String phone, String specialty, List<Consultation> consultations) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.specialty = specialty;
        this.consultations = consultations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }
}
