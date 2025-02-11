package com.vitordev.clinicalapi.adapters.in.response;

import lombok.Data;

@Data
public class DoctorDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String specialty;
}
