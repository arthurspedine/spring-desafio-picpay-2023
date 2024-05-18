package com.picpaysimplificado.infra;

import com.picpaysimplificado.dto.ExceptionDTO;
import com.picpaysimplificado.infra.exception.ValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerValidationExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threadDuplicateEntity(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO("User already created!", "400"));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity thread404(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity threadGeneralExceptions(ValidationException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage(), "400"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity tratarErro500(Exception e) {
        return ResponseEntity.internalServerError().body(new ExceptionDTO(e.getLocalizedMessage(), "500"));
    }



}
