package com.uniquindio.sebas.guia5.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.uniquindio.sebas.guia5.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@RestControllerAdvice
@ControllerAdvice

/**
             * CLASE GLOBAL PARA EL MANEJO DE EXCEPCIONES, DE MODO QUE LA RESPUESTA SEA AMIGABLE
             * Y LOS ERRORES SEAN CONSISTENTES
 */
public class GlobalExceptionsHandler {

        @ExceptionHandler(ValueConflictExceptions.class) //calse que obtendra los valores de la exepcion
        public ResponseEntity<ErrorResponse> handleValueConflictExceptions(ValueConflictExceptions e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("ERROR",e.getMessage()));
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<ErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) { //aquie es importante manejar el argumento con una variable distinta de 'e'
                return ResponseEntity.status(HttpStatus.CONFLICT).body(
                        ex.getFieldErrors().stream().map(
                                e-> new ErrorResponse("ERROR",e.getField()+"->"+e.getDefaultMessage())
                        ).toList()
                );
        }
}
