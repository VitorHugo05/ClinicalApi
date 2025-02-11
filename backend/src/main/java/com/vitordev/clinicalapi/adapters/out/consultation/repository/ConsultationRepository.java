package com.vitordev.clinicalapi.adapters.out.consultation.repository;

import com.vitordev.clinicalapi.adapters.out.consultation.repository.entity.ConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {
    Optional<List<ConsultationEntity>> findByDoctorId(Long id);
    Optional<List<ConsultationEntity>> findByPatientId(Long id);
    Optional<List<ConsultationEntity>> findByDoctorIdAndDateEquals(Long doctorId, LocalDate date);
}
