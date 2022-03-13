package pl.web.instalook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.web.instalook.model.Role;

import java.util.Collection;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

    private String login;
    private String password;
    private Collection<Role> name;
}
