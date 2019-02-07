package com.andersen.javatrainee.web.user;

import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.service.DictionaryService;
import com.andersen.javatrainee.service.UserService;
import com.andersen.javatrainee.to.DictionaryTO;
import com.andersen.javatrainee.util.Util;
import com.andersen.javatrainee.util.exception.DuplicateFoundException;
import com.andersen.javatrainee.util.exception.ExceptionUtil;
import com.andersen.javatrainee.web.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

import static com.andersen.javatrainee.util.Util.createDictionaryFromTO;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private DictionaryService dictionaryService;

    @Autowired
    public AdminController(UserService userService, DictionaryService dictionaryService) {
        this.userService = userService;
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("userTo", new User());
        model.addAttribute("roles", Util.makeRolesList());
        model.addAttribute("create", true);
        return "userForm";
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(@RequestParam Integer id, Model model) {
        model.addAttribute("userTo", userService.get(id));
        model.addAttribute("roles", Util.makeRolesList());
        return "userForm";
    }

    @PostMapping("/createOrUpdateUser")
    public String createOrUpdateUser(@Valid @ModelAttribute("userTo") User user,
                                     BindingResult result, Model model,
                                     SessionStatus status,
                                     @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        if (result.hasErrors()) {
            Object target = result.getTarget();
            if (target != null && target instanceof User) {
                ((User) target).setLogin(authorizedUser.getUser().getLogin());
            }
            model.addAttribute("roles", Util.makeRolesList());
            return "userForm";
        }
        try {
            userService.save(user);
        } catch (DuplicateFoundException e) {
            return ExceptionUtil.handleDuplicateException(model, e, "userForm",
                    authorizedUser.getUser());
        }
        status.setComplete();
        return "redirect:/admin/users";
    }

    @PostMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

    ////////////////*Dictionary-methods*//////////////////

    @GetMapping("/dicts")
    public String showDictionaries(Model model) {
        model.addAttribute("dicts", dictionaryService.getAll());
        return "dicts";
    }

    @GetMapping("/createDict")
    public String createDict(Model model) {
        model.addAttribute("dictTo", new DictionaryTO());
        model.addAttribute("dictTypes", Util.makeDictTypesList());
        model.addAttribute("create", true);
        return "dictForm";
    }

    @GetMapping(value = "/updateDict")
    public String updateDict(@RequestParam Integer id, Model model) {
        model.addAttribute("dictTo", Util.createDictionaryTO(dictionaryService.get(id)));
        model.addAttribute("dictTypes", Util.makeDictTypesList());
        return "dictForm";
    }

    @PostMapping("/createOrUpdateDict")
    public String createOrUpdateDict(@Valid @ModelAttribute("dictTo") DictionaryTO dictTO,
                                     BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("dictTypes", Util.makeDictTypesList());
            return "dictForm";
        }
        dictionaryService.save(createDictionaryFromTO(dictTO));
        status.setComplete();
        return "redirect:/admin/dicts";
    }

    @PostMapping("/deleteDict/{id}")
    public String deleteDict(@PathVariable Integer id) {
        dictionaryService.delete(id);
        return "redirect:/admin/dicts";
    }
}

// TODO: 07.02.2019
//  admin new user creation/update - role problem
//  list of roles not updating after add of new roleName