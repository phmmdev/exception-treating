package com.exception.treatment.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiRequestExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e, WebRequest webRequest)
    {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiRequesExceptionMessage apiRequesExceptionMessage=  new ApiRequesExceptionMessage(
          e.getMessage(),
          httpStatus,
          ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiRequesExceptionMessage, httpStatus);
    }
}
