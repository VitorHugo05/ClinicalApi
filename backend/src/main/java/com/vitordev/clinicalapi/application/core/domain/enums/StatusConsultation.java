package com.vitordev.clinicalapi.application.core.domain.enums;

public enum StatusConsultation {
    APPOINTMENT("appointment"),
    CANCELLED("cancelled"),
    CARRIED_OUT("carriedOut"),;

    private final String status;

    StatusConsultation(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
