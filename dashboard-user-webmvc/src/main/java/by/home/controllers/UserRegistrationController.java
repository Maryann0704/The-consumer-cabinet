package by.home.controllers;

import by.home.pojo.AppUser;
import by.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationPage(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerForm(@ModelAttribute AppUser user,
                               BindingResult bindingResult) {
        if (userService.saveUser(user)) {
            return "login";
        } else
            return "registration";
    }

}
