package com.vitordev.clinicalapi.infra.security;

public enum UserRole {
    DOCTOR("Doctor"),
    PATIENT("Patient"),
    ADMIN("Admin"),;

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
