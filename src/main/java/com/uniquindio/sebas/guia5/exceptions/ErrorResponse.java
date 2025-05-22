package com.uniquindio.sebas.guia5.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String code;
    private String message;

    // Constructor, getters y setters
    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
