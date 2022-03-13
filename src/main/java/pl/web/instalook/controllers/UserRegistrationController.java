
package pl.web.instalook.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.web.instalook.dto.UserRegistrationDto;
import pl.web.instalook.model.Role;
import pl.web.instalook.repository.RoleRepository;
import pl.web.instalook.service.UserService;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private UserService userService;
    private RoleRepository repository;

    @ModelAttribute("instalook_users")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(UserRegistrationDto registrationDto) {

        Role role;

        if (!registrationDto.getLogin().contains(" ") && !registrationDto.getPassword().contains(" ")) {

            try {

                role = repository.findByName("NEW USER");
                registrationDto.setName(List.of(role));
                userService.save(registrationDto);

                return "redirect:/login?success";
            }
            catch (ConstraintViolationException e) {

                return "redirect:/registration?error";
            }
            catch (Exception e){

                e.printStackTrace();
                return "redirect:/registration?bussy";
            }

        } else
            return "redirect:/registration?error";
    }
}
