package com.vitordev.clinicalapi.adapters.out.patient.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import com.vitordev.clinicalapi.infra.security.UserEntity;
import com.vitordev.clinicalapi.infra.security.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_patient")
@ToString(exclude = "consultations")
public class PatientEntity extends UserEntity {
    @OneToMany(mappedBy = "patient")
    @JsonBackReference
    private List<ConsultationEntity> consultations = new ArrayList<>();

    public PatientEntity() {
        setUserRole(UserRole.PATIENT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEntity that = (PatientEntity) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
