package com.systemRealEstate.systemRealEstate.controller;

import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {


    @ExceptionHandler({NullPointerException.class, EntityNotFoundException.class})
    public ResponseEntity<?> errorDoesntExist(Exception e){
        Map<String,Object> error = new HashMap<>();
        error.put("Message","El registro no se encuentra en la Base de Datos");
        error.put("Information","Informacion sobre el error :"+e);
        error.put("Status","500");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> errorValidation(Exception e){
        Map<String,Object> error = new HashMap<>();
        error.put("Message","Hay un error en una de las Validaciones");
        error.put("Information","Informacion sobre el error :" +e);
        error.put("Status","500");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
