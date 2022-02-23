
package pl.web.instalook.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.web.instalook.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    void save(UserRegistrationDto urDTO);
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

