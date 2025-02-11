package com.vitordev.clinicalapi.adapters.out.consultation.repository.entity;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.enums.StatusConsultationEntity;
import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import com.vitordev.clinicalapi.adapters.out.patient.repository.entity.PatientEntity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_consultation")
public class ConsultationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    private Date date;

    @Enumerated(EnumType.STRING)
    private StatusConsultationEntity status;
}
