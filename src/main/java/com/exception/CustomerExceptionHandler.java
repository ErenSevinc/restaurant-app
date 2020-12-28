package com.exception;

import com.DTO.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Date;
@RestController
@ControllerAdvice
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler {

    private ErrorResponseDTO prepareResponseModel(String message, WebRequest request){
        return new ErrorResponseDTO(new Date(),message,request.getDescription(true));
    }

    @ExceptionHandler(BusinessRuleException.class)
    public final ResponseEntity<ErrorResponseDTO> handleBusinessException(BusinessRuleException e, WebRequest request){
        ErrorResponseDTO responseDTO= prepareResponseModel(e.getMessage(),request);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(SystemException.class)
    public final ResponseEntity<ErrorResponseDTO> handleSystemException(SystemException e, WebRequest request){
        ErrorResponseDTO responseDTO= prepareResponseModel(e.getMessage(),request);
        return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponseDTO> handleExceptions(Exception e, WebRequest request){
        ErrorResponseDTO responseDTO= prepareResponseModel(e.getMessage(),request);
        return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
