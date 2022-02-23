
package pl.web.instalook.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.web.instalook.dto.UserRegistrationDto;
import pl.web.instalook.service.UserService;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private UserService userService;

    @ModelAttribute("instalook_users")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("instalook_users") UserRegistrationDto registrationDto) {
        if (!registrationDto.getLogin().contains(" ") && !registrationDto.getPassword().contains(" ")) {

            try {
                userService.save(registrationDto);
                return "redirect:/login?success";
            } catch (Exception e) {
                return "redirect:/registration?bussy";
            }
        }
        else{
            return "redirect:/registration?error";
        }
    }
}
