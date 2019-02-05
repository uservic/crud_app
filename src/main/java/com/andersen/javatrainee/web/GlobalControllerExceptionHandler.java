package com.andersen.javatrainee.web;

import com.andersen.javatrainee.util.exception.DuplicateFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(DuplicateFoundException.class)
    public ModelAndView duplicateLogin(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView("errors/duplicateError");
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }

}