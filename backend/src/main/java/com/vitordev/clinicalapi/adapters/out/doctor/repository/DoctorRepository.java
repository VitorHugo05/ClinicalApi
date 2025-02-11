package com.vitordev.clinicalapi.adapters.out.doctor.repository;

import com.vitordev.clinicalapi.adapters.out.doctor.repository.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
}
