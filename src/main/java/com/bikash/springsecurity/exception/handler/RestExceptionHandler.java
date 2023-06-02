package com.bikash.springsecurity.exception.handler;

import com.bikash.springsecurity.dto.ServerResponse;
import com.bikash.springsecurity.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Bikash Shah
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerException.class)
    protected ResponseEntity<Object> handleServerException(ServerException ex) {
        log.error("Exception message : {}", ex.getServerResponse().getMessage());

        if (log.isDebugEnabled()) {
            log.error("Exception : ", ex);
        }

        ServerResponse serverResponse = ex.getServerResponse();

        ServerResponse genericResponse = new ServerResponse();
        genericResponse.setSuccess(serverResponse.isSuccess());
        genericResponse.setMessage(serverResponse.getMessage());
        genericResponse.setUnicodeMessage(serverResponse.getUnicodeMessage());
       // genericResponse.setProcessingCode(ex.getProcessingCode());
        return buildResponseEntity(genericResponse, ex.getHttpStatus());
    }
    private ResponseEntity<Object> buildResponseEntity(ServerResponse genericResponse, HttpStatus httpStatus) {
        return new ResponseEntity<>(httpStatus);
    }
}
