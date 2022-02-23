package pl.web.instalook.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.web.instalook.service.UserService;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private UserService userService;

    @GetMapping
    public String login() {
        return "login";
    }
}
