package com.andersen.javatrainee.web.user;

import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.service.UserService;
import com.andersen.javatrainee.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService service;

    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", service.getAll());
        return "users";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("userTo", new User());
        model.addAttribute("roles", UserUtil.makeRolesList());
        model.addAttribute("create", true);
        return "userForm";
    }

    @GetMapping(value = "/update")
    public String updateUser(@RequestParam Integer id, Model model) {
        model.addAttribute("userTo", service.get(id));
        model.addAttribute("roles", UserUtil.makeRolesList());
        return "userForm";
    }

    @PostMapping("/createOrUpdateUser")
    public String createOrUpdateUser(@Valid @ModelAttribute("userTo") User user,
                                     BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roles", UserUtil.makeRolesList());
            return "userForm";
        }
        service.save(user);
        return "redirect:users";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam Integer id, Model model) {
        service.delete(id);
        model.addAttribute("users", service.getAll());
        return "users";
    }

    @GetMapping("/dicts")
    public String showDictionaries() {
        return "dicts";
    }

}