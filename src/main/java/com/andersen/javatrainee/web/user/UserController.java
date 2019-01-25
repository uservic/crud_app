package com.andersen.javatrainee.web.user;

import com.andersen.javatrainee.model.Role;
import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registerForm";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        user.setRole(new Role(1, "User", 1));
        service.save(user);
        return "redirect:/user/" + user.getLogin();
    }

    @GetMapping("/{login}")
    public String showProfile(@PathVariable String login, Model model) {
        User user = service.getByLogin(login);
        model.addAttribute(user);
        return "profile";
    }

}