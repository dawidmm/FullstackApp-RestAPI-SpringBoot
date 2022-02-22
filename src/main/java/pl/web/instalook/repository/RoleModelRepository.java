package pl.web.instalook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.web.instalook.model.RoleModel;

@Repository
public interface RoleModelRepository extends JpaRepository<RoleModel, Long> {

    RoleModel findByName(String name);
}
