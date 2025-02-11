package com.vitordev.clinicalapi.adapters.in.requests;

import lombok.Data;

@Data
public class PatientRequest {
    private String name;
    private String email;
    private String phone;
}
