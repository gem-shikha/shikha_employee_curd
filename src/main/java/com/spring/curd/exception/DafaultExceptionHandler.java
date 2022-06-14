package com.spring.curd.exception;

import com.spring.curd.entity.EmployeeError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class DafaultExceptionHandler {

     @ExceptionHandler(Exception.class)
     public ResponseEntity<EmployeeError> mapException(Exception ex){
        EmployeeError error =
                new EmployeeError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
        return new ResponseEntity<EmployeeError>(error,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
     }
}

