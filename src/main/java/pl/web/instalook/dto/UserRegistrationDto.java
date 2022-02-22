package pl.web.instalook.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UserRegistrationDto {

    private String login;
    private String password;

    public UserRegistrationDto() {}
}
