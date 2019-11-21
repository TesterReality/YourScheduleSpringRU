package ru.notes.rutodolist.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.notes.rutodolist.repr.UserRepr;
import ru.notes.rutodolist.service.UserService;

import javax.validation.Valid;

/**
 * Created by user on 14.11.2019.
 */
@Controller
public class LoginController {

    private static final Logger loger = LoggerFactory.getLogger(LoginController.class);
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model)
    {
        model.addAttribute("user",new UserRepr());
        loger.info("Create New Obj User");

        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(
            @ModelAttribute("user")
            @Valid UserRepr userRepr,
            BindingResult result)
    {
        if(result.hasErrors())
        {
            return "register";
        }

        if(!userRepr.getPswd().equals(userRepr.getMatchingPswd()))
        {
            result.rejectValue("pswd","","Пароли не совпали");
            return "register";
        }
        userService.create(userRepr);
        loger.info("New User {}",userRepr);
        return "redirect:/login";
    }
}
