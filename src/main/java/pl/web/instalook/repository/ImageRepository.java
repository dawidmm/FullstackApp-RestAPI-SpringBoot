package pl.web.instalook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.web.instalook.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
