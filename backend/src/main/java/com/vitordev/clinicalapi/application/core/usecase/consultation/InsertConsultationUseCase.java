package com.vitordev.clinicalapi.application.core.usecase.consultation;

import com.vitordev.clinicalapi.application.core.domain.Consultation;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.core.domain.Patient;
import com.vitordev.clinicalapi.application.ports.in.consultation.FindConsultationsByDoctorIdAndDateInputPort;
import com.vitordev.clinicalapi.application.ports.in.consultation.InsertConsultationInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.patient.FindPatientByIdInputPort;
import com.vitordev.clinicalapi.application.ports.out.consultation.InsertConsultationOutputPort;
import com.vitordev.clinicalapi.application.ports.out.doctor.InsertDoctorOutputPort;
import com.vitordev.clinicalapi.application.ports.out.patient.InsertPatientOutputPort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class InsertConsultationUseCase implements InsertConsultationInputPort {
    private final InsertConsultationOutputPort insertConsultationOutputPort;
    private final FindConsultationsByDoctorIdAndDateInputPort findConsultationsByDoctorIdAndDateInputPort;
    private final FindDoctorByIdInputPort findDoctorByIdInputPort;
    private final FindPatientByIdInputPort findPatientByIdInputPort;
    private final InsertPatientOutputPort insertPatientOutputPort;
    private final InsertDoctorOutputPort insertDoctorOutputPort;

    public InsertConsultationUseCase(
            InsertConsultationOutputPort insertConsultationOutputPort,
            FindConsultationsByDoctorIdAndDateInputPort findConsultationsByDoctorIdAndDateInputPort,
            FindDoctorByIdInputPort findDoctorByIdInputPort,
            FindPatientByIdInputPort findPatientByIdInputPort,
            InsertPatientOutputPort insertPatientOutputPort,
            InsertDoctorOutputPort insertDoctorOutputPort
    ) {
        this.insertConsultationOutputPort = insertConsultationOutputPort;
        this.findConsultationsByDoctorIdAndDateInputPort = findConsultationsByDoctorIdAndDateInputPort;
        this.findDoctorByIdInputPort = findDoctorByIdInputPort;
        this.findPatientByIdInputPort = findPatientByIdInputPort;
        this.insertPatientOutputPort = insertPatientOutputPort;
        this.insertDoctorOutputPort = insertDoctorOutputPort;
    }
    
    @Override
    public void insert(Consultation consultation) {
        if (consultation.getStartAt() == null || consultation.getEndAt() == null) {
            throw new RuntimeException("Os campos 'startAt' e 'endAt' não podem ser nulos.");
        }

        if (consultation.getStartAt().isAfter(consultation.getEndAt())) {
            throw new RuntimeException("O horário de início não pode ser maior que o de término.");
        }

        if (Duration.between(consultation.getStartAt(), consultation.getEndAt()).toMinutes() < 30) {
            throw new RuntimeException("A consulta deve ter no mínimo 30 minutos.");
        }

        List<Consultation> consultationList = findConsultationsByDoctorIdAndDateInputPort
                .find(consultation.getDoctor().getId(), consultation.getDate());
        
        boolean hasConflict = consultationList.stream()
                .anyMatch(existingConsultation -> isTimeOverlap(
                        existingConsultation.getStartAt(),
                        existingConsultation.getEndAt(),
                        consultation.getStartAt(),
                        consultation.getEndAt()
                ));

        if (hasConflict) {
            throw new RuntimeException("O médico já possui uma consulta agendada neste horário.");
        }
        
        insertConsultationOutputPort.insert(consultation);

        Doctor doctor = findDoctorByIdInputPort.find(consultation.getDoctor().getId());
        Patient patient = findPatientByIdInputPort.find(consultation.getPatient().getId());

        doctor.getConsultations().add(consultation);
        patient.getConsultations().add(consultation);

        insertDoctorOutputPort.insert(doctor);
        insertPatientOutputPort.insert(patient);
    }

    private boolean isTimeOverlap(LocalTime startExisting, LocalTime endExisting, LocalTime startNew, LocalTime endNew) {
        return !startNew.isAfter(endExisting) && !startExisting.isAfter(endNew);
    }
}
