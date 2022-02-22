
package pl.web.instalook.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.web.instalook.model.UserModel;
import pl.web.instalook.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    UserModel save(UserRegistrationDto urDTO);
}

