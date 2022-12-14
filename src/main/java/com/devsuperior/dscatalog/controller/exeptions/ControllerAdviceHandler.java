package com.devsuperior.dscatalog.controller.exeptions;

import com.devsuperior.dscatalog.services.exeptions.DataBaseException;
import com.devsuperior.dscatalog.services.exeptions.ServiceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerAdviceHandler {


    @ExceptionHandler(ServiceNotFoundException.class) // argumento para saber que tipo de exceção ele trata.
    public ResponseEntity<StandardError> entityNotFound(ServiceNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTimeStamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setError("Resourse not found");
        err.setMessage(e.getMessage());
        err.setPath((request.getRequestURI()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimeStamp(Instant.now());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setError("Database Exception");
        err.setMessage(e.getMessage());
        err.setPath((request.getRequestURI()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
