package com.vitordev.clinicalapi.adapters.out.patient.repository.entity;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<ConsultationEntity> consultation = new ArrayList<>();
}
