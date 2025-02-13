package com.vitordev.clinicalapi.adapters.out.doctor.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.infra.security.UserEntity;
import com.vitordev.clinicalapi.infra.security.UserRole;
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
@Table(name = "tb_doctor")
public class DoctorEntity extends UserEntity {
    private String specialty;

    @OneToMany(mappedBy = "doctor")
    @JsonBackReference
    private List<ConsultationEntity> consultations = new ArrayList<>();

    public DoctorEntity() {
        setUserRole(UserRole.DOCTOR);
    }
}
