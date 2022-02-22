package pl.web.instalook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.web.instalook.model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Long> {

    UserModel findByLogin(String login);
}