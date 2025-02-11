package com.vitordev.clinicalapi.adapters.out.repository;

import com.vitordev.clinicalapi.adapters.out.repository.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
}
