package com.ecommerce.productservice.controlleradvice;

import com.ecommerce.productservice.Exceptions.IdOutOfBoundException;
import com.ecommerce.productservice.Exceptions.ProductNotFoundException;
import com.ecommerce.productservice.Models.Product;
import com.ecommerce.productservice.dtos.ExceptionDto;
import com.ecommerce.productservice.dtos.ExceptionIndexDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handlerProductNotFound(ProductNotFoundException ex){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(ex.getMessage()+" Not found");
        exceptionDto.setSolution("try with Valid Product Id");
        ResponseEntity<ExceptionDto> response=
                new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }
    @ExceptionHandler(IdOutOfBoundException.class)
    public ResponseEntity<ExceptionIndexDto> handlerIdOutOfBound(IdOutOfBoundException ex){
        ExceptionIndexDto exceptionDto = new ExceptionIndexDto();
        exceptionDto.setMessage(ex.getMessage());
        exceptionDto.setSolution("try with Valid Product Id");
        ResponseEntity<ExceptionIndexDto> response
                =new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;

    }


}
