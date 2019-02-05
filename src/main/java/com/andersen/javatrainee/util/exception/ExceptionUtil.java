package com.andersen.javatrainee.util.exception;

import org.springframework.ui.Model;

public class ExceptionUtil {

    public static String handleDuplicateException(Model model, Exception e, String view) {
        model.addAttribute("errMsg", e.getMessage() + ". Please, enter another login.");
        return view;
    }

}