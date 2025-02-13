package com.vitordev.clinicalapi.adapters.in.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
