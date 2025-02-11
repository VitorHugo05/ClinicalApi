package com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.enums;

public enum StatusConsultationEntity {
    APPOINTMENT("appointment"),
    CANCELLED("cancelled"),
    CARRIED_OUT("carriedOut"),;

    private final String status;

    StatusConsultationEntity(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}

