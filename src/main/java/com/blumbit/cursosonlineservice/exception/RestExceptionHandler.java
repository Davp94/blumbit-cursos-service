package com.blumbit.cursosonlineservice.exception;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.blumbit.cursosonlineservice.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<List<String>>> handleValidationErrors(MethodArgumentNotValidException ex, HttpServletRequest request){
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(new ErrorResponse<List<String>>(HttpStatus.BAD_REQUEST.value(), errors, new Date().toString(), request.getRequestURI()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CategoriaNotFoundException.class)
    public ResponseEntity<ErrorResponse<String>> handleCategoriaNotFoundErrors(CategoriaNotFoundException ex, HttpServletRequest request){
        return new ResponseEntity<>(new ErrorResponse<String>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date().toString(), request.getRequestURI()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
