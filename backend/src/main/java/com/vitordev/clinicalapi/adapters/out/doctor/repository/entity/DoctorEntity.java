package com.vitordev.clinicalapi.adapters.out.doctor.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_doctor")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String specialty;

    @OneToMany(mappedBy = "doctor")
    @JsonBackReference
    private List<ConsultationEntity> consultations = new ArrayList<>();
}
