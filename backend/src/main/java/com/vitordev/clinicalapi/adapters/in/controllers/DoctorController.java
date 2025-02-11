package com.vitordev.clinicalapi.adapters.in.controllers;

import com.vitordev.clinicalapi.adapters.in.mapper.DoctorMapper;
import com.vitordev.clinicalapi.adapters.in.requests.DoctorRequest;
import com.vitordev.clinicalapi.application.core.domain.Doctor;
import com.vitordev.clinicalapi.application.ports.in.DeleteDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.FindDoctorByIdInputPort;
import com.vitordev.clinicalapi.application.ports.in.InsertDoctorInputPort;
import com.vitordev.clinicalapi.application.ports.in.UpdateDoctorInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private InsertDoctorInputPort insertDoctorInputPort;

    @Autowired
    private FindDoctorByIdInputPort findDoctorByIdInputPort;

    @Autowired
    private UpdateDoctorInputPort updateDoctorInputPort;

    @Autowired
    DeleteDoctorByIdInputPort deleteDoctorByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.toDoctor(doctorRequest);
        insertDoctorInputPort.insert(doctor);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id) {
        var doctor = findDoctorByIdInputPort.find(id);
        return ResponseEntity.ok().body(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody DoctorRequest doctorRequest) {
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
