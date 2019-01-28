package com.andersen.javatrainee.web.user;

import com.andersen.javatrainee.model.Role;
import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.service.UserService;
import com.andersen.javatrainee.web.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

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
    public String showRegistrationForm(Model model) {
        model.addAttribute("userTo", new User());
        model.addAttribute("register", true);
        return "profile";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("userTo") User user,
                                      BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        }
        user.setRole(new Role(1, "User", 1));
        service.save(user);
        status.setComplete();
        return "redirect:/home?message=You are registered. Please Sign in.";
    }

    @GetMapping("/profile")
    public String showProfile(Model model, @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        model.addAttribute("userTo", authorizedUser.getUser());
        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@Valid @ModelAttribute("userTo") User user, BindingResult result,
                                @AuthenticationPrincipal AuthorizedUser authorizedUser,
                                SessionStatus status) {

        if (result.hasErrors()) {
            return "profile";
        }
        user.setId(authorizedUser.getId());
        user.setRole(authorizedUser.getRole());
        authorizedUser.setUser(service.save(user));
        status.setComplete();
        return "redirect:profile?changed=true";
    }

}