package com.vitordev.clinicalapi.application.core.domain;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<Consultation> consultations = new ArrayList<>();

    public Patient() {}

    public Patient(Long id, String name, String email, String phone, String password, List<Consultation> consultations) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.consultations = consultations;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Consultation> getConsultations() {
        return consultations;
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
}
