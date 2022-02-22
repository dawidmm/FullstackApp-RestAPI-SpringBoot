
package pl.web.instalook.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.web.instalook.dto.UserRegistrationDto;
import pl.web.instalook.service.UserService;

@Controller
//@RequestMapping("/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private UserService userService;

    @ModelAttribute("instalook_users")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("instalook_users") UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/login?success";
        //return "redirect:/registration?success";
    }
}
