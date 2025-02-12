package com.vitordev.clinicalapi.adapters.out.consultation.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.enums.StatusConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "tb_consultation")
public class ConsultationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonManagedReference
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonManagedReference
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonManagedReference
    private PatientEntity patient;

    @JsonManagedReference
    private LocalTime startAt;

    @JsonManagedReference
    private LocalTime endAt;

    @JsonManagedReference
    private LocalDate date;

    @JsonManagedReference
    @Enumerated(EnumType.STRING)
    private StatusConsultationEntity status;
}
