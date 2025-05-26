package com.uniquindio.sebas.guia5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Maneja excepciones globales de la aplicación para respuestas HTTP consistentes y amigables.
 * - Centraliza el manejo de errores.
 * - Procesa validaciones (@Valid) y conflictos de negocio.
 */
@RestControllerAdvice // Combina @ControllerAdvice + @ResponseBody (suficiente, no necesita ambas anotaciones)
public class GlobalExceptionsHandler {

        // ===== Excepciones Específicas =====
        @ExceptionHandler(ValueConflictExceptions.class)
        public ResponseEntity<ErrorResponse> handleValueConflict(ValueConflictExceptions ex) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(new ErrorResponse("CONFLICT_ERROR", ex.getMessage())); // Usa códigos descriptivos
        }

        // ===== Validaciones (@Valid) =====
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<ErrorResponse>> handleValidationErrors(MethodArgumentNotValidException ex) {
                List<ErrorResponse> errors = ex.getFieldErrors()
                        .stream()
                        .map(this::mapToErrorResponse)
                        .collect(Collectors.toList()); // Más legible que .toList()

                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST) // 400 es más apropiado para validaciones fallidas
                        .body(errors);
        }

        // ===== Excepciones Genéricas (Fallback) =====
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleUnknownException(Exception ex) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ErrorResponse("INTERNAL_ERROR", "Ocurrió un error inesperado"));
        }

        // ===== Métodos Auxiliares =====
        private ErrorResponse mapToErrorResponse(FieldError fieldError) {
                return new ErrorResponse(
                        "VALIDATION_ERROR",
                        String.format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage())
                );
        }

        /*@ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleAll(Exception ex) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error: " + ex.getMessage());
        }*/
}