package com.vitordev.clinicalapi.adapters.in.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
}
