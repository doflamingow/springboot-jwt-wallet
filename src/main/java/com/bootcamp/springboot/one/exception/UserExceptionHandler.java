package com.bootcamp.springboot.one.exception;

import com.bootcamp.springboot.one.dto.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.io.FileNotFoundException;


@ControllerAdvice
public class UserExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = UserException.class)
    public ResponseEntity<CommonResponse> resp(UserException e){
        LOGGER.info("catchUserException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse(e.getCode(), e.getDescription()), HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CommonResponse> respExc(Exception e){
        LOGGER.info("catchException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse("500", "Not Allowed"), HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<CommonResponse> respEntity(EntityNotFoundException e){
        LOGGER.info("catchEntityNotFoundException");
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse("422", "No Entity"), HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<CommonResponse> respHttpMethod(HttpRequestMethodNotSupportedException e){
        LOGGER.info("catchHttpRequestMethodNotSupportedException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse("405", e.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<CommonResponse> respNullPointerException(NullPointerException e){
        LOGGER.info("catchNullPointerException");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse("500", "Not Allowed"), HttpStatus.OK);
    }

    @ExceptionHandler(value = FileNotFoundException.class)
    public ResponseEntity<CommonResponse> respFileNotFound(FileNotFoundException e){
        LOGGER.info("catchFileNotFound");
        LOGGER.error(e.getMessage());
        LOGGER.warn(e.getMessage());
        LOGGER.info(e.getMessage());
        LOGGER.debug(e.getMessage());
        return new ResponseEntity<CommonResponse>(new CommonResponse("404", "Not Found"), HttpStatus.OK);
    }
}
