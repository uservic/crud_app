package com.andersen.javatrainee.util.exception;

import com.andersen.javatrainee.model.User;
import org.springframework.ui.Model;

public class ExceptionUtil {

    public static String handleDuplicateException(Model model, Exception e,
                                                  String view, User user) {
        model.addAttribute("errMsg", e.getMessage() + ". Please, enter another login.");
        model.addAttribute("userTo", user);
        return view;
    }

}