package com.sigaCompany.dvdStore.dto;

import lombok.Data;

/**
 * The type Auth request dto.
 */
@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
