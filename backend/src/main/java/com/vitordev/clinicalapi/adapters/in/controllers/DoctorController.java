package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.DoctorDtoMapper;
import com.vitordev.clinicalapi.adapters.in.mapper.DoctorMapper;
import com.vitordev.clinicalapi.adapters.in.requests.DoctorRequest;
import com.vitordev.clinicalapi.adapters.in.response.DoctorDTO;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.in.doctor.DeleteDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.doctor.UpdateDoctorInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private DoctorDtoMapper doctorDtoMapper;

    @Autowired
    private FindDoctorByIdInputPort findDoctorByIdInputPort;

    @Autowired
    private UpdateDoctorInputPort updateDoctorInputPort;

    @Autowired
    DeleteDoctorByIdInputPort deleteDoctorByIdInputPort;

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> findById(@PathVariable Long id) {
        var doctor = findDoctorByIdInputPort.find(id);
        return ResponseEntity.ok().body(doctorDtoMapper.toDTO(doctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid DoctorRequest doctorRequest) {
        findDoctorByIdInputPort.find(id);
        Doctor doctor = doctorMapper.toDoctor(doctorRequest);
        doctor.setId(id);
        updateDoctorInputPort.update(doctor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteDoctorByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
