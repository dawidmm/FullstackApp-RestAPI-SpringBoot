
package pl.web.instalook.service;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.web.instalook.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    void save(UserRegistrationDto urDTO);
}

