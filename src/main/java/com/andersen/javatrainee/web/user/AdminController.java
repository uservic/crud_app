package com.andersen.javatrainee.web.user;

import com.andersen.javatrainee.model.Role;
import com.andersen.javatrainee.model.User;
import com.andersen.javatrainee.service.DictionaryService;
import com.andersen.javatrainee.service.UserService;
import com.andersen.javatrainee.to.DictionaryTO;
import com.andersen.javatrainee.util.Util;
import com.andersen.javatrainee.util.exception.DuplicateFoundException;
import com.andersen.javatrainee.web.AuthorizedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.beans.PropertyEditorSupport;

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
        resetCreateUserFormView(model);
        return "userForm";
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(@RequestParam Integer id, Model model) {
        model.addAttribute("userTo", userService.get(id));
        model.addAttribute("roles", dictionaryService.getAllRoles());
        return "userForm";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("userTo") User user,
                             BindingResult result, Model model,
                             SessionStatus status,
                             @AuthenticationPrincipal AuthorizedUser authorizedUser) {
        if (result.hasErrors()) {
            resetCreateUserFormView(model);
            return "userForm";
        }

        try {
            userService.save(user);
        } catch (DuplicateFoundException e) {
            resetCreateUserFormView(model);
            model.addAttribute("errMsg", e.getMessage() + ". Please, enter another login.");
            return "userForm";
        }
        status.setComplete();
        return "redirect:/admin/users";
    }

    @PostMapping("/updateUser")
    public String updateProfile(@Valid @ModelAttribute("userTo") User user, BindingResult result,
                                Model model, SessionStatus status, HttpServletRequest request) {

        if (result.hasErrors()) {
            resetUpdateUserFormView(request, "originalLogin", result, model);
            return "userForm";
        }
        try {
            userService.save(user);
        } catch (DuplicateFoundException e) {
            resetUpdateUserFormView(request, "originalLogin", result, model);
            model.addAttribute("errMsg", e.getMessage() + ". Please, enter another login.");
            return "userForm";
        }
        status.setComplete();
        return "redirect:/admin/users";
    }

    @PostMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/admin/users";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {

        binder.registerCustomEditor(Role.class, "role", new PropertyEditorSupport() {

            public void setAsText(String text) {
                Role buildingType = dictionaryService.getRoleByName(text);
                setValue(buildingType);
            }
        });

    }

    private void resetCreateUserFormView(Model model) {
        model.addAttribute("roles", dictionaryService.getAllRoles());
        model.addAttribute("create", true);
    }

    private void resetUpdateUserFormView(HttpServletRequest request, String param,
                                         BindingResult result, Model model) {
        String originalLogin = request.getParameter(param);
        Object target = result.getTarget();
        if (target instanceof User) {
            ((User) target).setLogin(originalLogin);
        }
        model.addAttribute("roles", dictionaryService.getAllRoles());
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
