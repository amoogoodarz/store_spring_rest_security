package com.amoogoodarz.store.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

@Data
public class JwtResponse {
    private String token;
}
