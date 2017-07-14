package com.build.oa.conf;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xzhang on 7/14/2017.
 */
@ControllerAdvice
public class OAExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> exception(HttpServletRequest request,Exception ex){
        return new ResponseEntity<String>(ex.getMessage(),getStatuse(request));
    }

    private HttpStatus getStatuse(ServletRequest request){
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR; //500 runtime exception
        }
        return HttpStatus.valueOf(statusCode);
    }
}
