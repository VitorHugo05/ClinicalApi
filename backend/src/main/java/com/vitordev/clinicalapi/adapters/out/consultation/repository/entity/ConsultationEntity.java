package com.vitordev.clinicalapi.adapters.out.consultation.repository.entity;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.enums.StatusConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "tb_consultation")
@ToString(exclude = {"doctor", "patient"})
public class ConsultationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    private LocalTime startAt;
    private LocalTime endAt;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatusConsultationEntity status;
}
