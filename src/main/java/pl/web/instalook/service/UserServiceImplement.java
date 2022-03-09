package pl.web.instalook.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.web.instalook.config.BCryptConfiguration;
import pl.web.instalook.model.RoleModel;
import pl.web.instalook.model.UserModel;
import pl.web.instalook.repository.UserModelRepository;
import pl.web.instalook.dto.UserRegistrationDto;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplement implements UserService {

    private UserModelRepository userModelRepository;
    private BCryptConfiguration passwordEncoder;

    @Override
    public void save(UserRegistrationDto urDTO) {
        UserModel user = new UserModel(urDTO.getLogin(), passwordEncoder.passwordEncod().encode(urDTO.getPassword()), urDTO.getName());
        //List.of(new RoleModel("NEW_USER"))
        userModelRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = userModelRepository.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("Zła nazwa użytkownika lub hasło");
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleModel> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
