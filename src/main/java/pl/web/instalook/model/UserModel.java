package pl.web.instalook.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "instalook_users", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class UserModel {
    public UserModel(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "instalook_user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"))
    private Collection<RoleModel> roles;


    public UserModel(String login, String password, Collection<RoleModel> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }
}
