package com.vitordev.clinicalapi.adapters.in.requests;

import lombok.Data;

@Data
public class DoctorRequest {
    private String name;
    private String email;
    private String phone;
    private String specialty;
}
