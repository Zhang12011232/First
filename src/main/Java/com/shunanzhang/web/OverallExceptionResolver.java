package com.shunanzhang.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shunan.zhang on 2018/7/26.
 */

@ControllerAdvice
public class OverallExceptionResolver{
    private static final Logger logger = LoggerFactory.getLogger(OverallExceptionResolver.class);
    private Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            map.put(error.getField(), error.getDefaultMessage());
        }
        return map;
    }
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map ex(MethodArgumentNotValidException exception, HttpServletResponse response){
        logger.error("发生参数校验异常:{}", exception);
        BindingResult bindingResult = exception.getBindingResult();
        Map<String,String> attrMap= getErrors(bindingResult);
        return attrMap;
    }

}

