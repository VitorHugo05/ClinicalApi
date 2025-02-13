package com.vitordev.clinicalapi.adapters.out.doctor.repository.entity;

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
@Table(name = "tb_doctor")
@ToString(exclude = "consultations")
public class DoctorEntity extends UserEntity {
    private String specialty;

    @OneToMany(mappedBy = "doctor")
    @JsonBackReference
    private List<ConsultationEntity> consultations = new ArrayList<>();

    public DoctorEntity() {
        setUserRole(UserRole.DOCTOR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEntity that = (DoctorEntity) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
