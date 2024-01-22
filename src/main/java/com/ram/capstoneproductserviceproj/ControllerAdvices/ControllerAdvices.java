package com.ram.capstoneproductserviceproj.ControllerAdvices;

import com.ram.capstoneproductserviceproj.DTO.ExceptionDTO;
import com.ram.capstoneproductserviceproj.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices
{

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> handleArthimeticException()
    {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("Something Fishy Happened . Please Contact Admin");

        return new ResponseEntity<>(dto,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException(ProductNotFoundException exception)
    {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage(exception.getMessage());

        return new ResponseEntity<>(dto,HttpStatus.BAD_REQUEST);
    }
}
