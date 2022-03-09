package pl.web.instalook;


import org.springframework.stereotype.Controller;
import pl.web.instalook.model.RoleModel;
import pl.web.instalook.repository.RoleModelRepository;

@Controller
public class Start {

    private RoleModelRepository repository;


    public Start(RoleModelRepository repository) {
        this.repository = repository;
        this.repository.save(new RoleModel("NEW USER"));
    }
}
