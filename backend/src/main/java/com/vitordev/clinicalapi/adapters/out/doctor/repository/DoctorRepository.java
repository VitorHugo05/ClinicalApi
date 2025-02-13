package com.vitordev.clinicalapi.adapters.out.doctor.repository;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    Optional<DoctorEntity> findByName(String name);

    Optional<DoctorEntity> findByEmail(String email);
}
