package com.zzz.springboot01.com.zzz.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * 异常处理类
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public Result jsonErrorHandler(HttpServletRequest req, Exception e){
        return ResultGenerator.genFailResult(e.getMessage());
    }
}
