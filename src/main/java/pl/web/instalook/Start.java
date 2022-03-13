package pl.web.instalook;


import org.springframework.stereotype.Controller;
import pl.web.instalook.config.BCryptConfiguration;
import pl.web.instalook.model.Role;
import pl.web.instalook.model.User;
import pl.web.instalook.repository.RoleRepository;
import pl.web.instalook.repository.UserRepository;

import java.util.List;

@Controller
public class Start {

    //Inicjalizacja początkowych danych do bazy H2

    private RoleRepository repository;
    private UserRepository userRepository;
    private BCryptConfiguration bCryptConfiguration;


    public Start(RoleRepository repository, UserRepository userRepository, BCryptConfiguration bCryptConfiguration) {
        this.repository = repository;
        this.userRepository = userRepository;

        //this.repository.save(new Role("NEW USER"));
        this.repository.save(new Role("USER"));
        this.repository.save(new Role("ADMIN"));

        User user = new User("dawid", bCryptConfiguration.passwordEncod().encode("dawid123"), List.of(new Role("NEW USER")));

        this.userRepository.save(user);
    }
}
