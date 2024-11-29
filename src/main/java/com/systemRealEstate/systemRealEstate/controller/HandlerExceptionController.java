package com.systemRealEstate.systemRealEstate.controller;

import com.systemRealEstate.systemRealEstate.controller.DTO.errorDTO;
import com.systemRealEstate.systemRealEstate.exception.CanNotCreateException;
import com.systemRealEstate.systemRealEstate.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class HandlerExceptionController {


    @ExceptionHandler({NotFoundException.class, EntityNotFoundException.class})
    public ResponseEntity<?> errorDoesntExist(Exception e){
        errorDTO error = new errorDTO("El registro no se encuentra en la base de datos",
                "Informacion sobre el error : "+ e, "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> errorValidation(Exception e){
       errorDTO error = new errorDTO("Ha ocurrido un error con alguna de nuestras validaciones",
               "Informacion sobre el error : "+e,"500");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler({CanNotCreateException.class})
    public ResponseEntity<?> errorCreate(Exception e){
        errorDTO error = new errorDTO("Ha ocurrido un error. No se pudo crear el registro",
                " "+e,"400"
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
