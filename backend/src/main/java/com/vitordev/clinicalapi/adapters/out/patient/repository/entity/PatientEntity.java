package com.vitordev.clinicalapi.adapters.out.patient.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.infra.security.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_patient")
public class PatientEntity extends UserEntity {
    @OneToMany(mappedBy = "patient")
    @JsonBackReference
    private List<ConsultationEntity> consultations = new ArrayList<>();
}
