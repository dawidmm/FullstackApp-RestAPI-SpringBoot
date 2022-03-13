package pl.web.instalook.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.web.instalook.dto.ImageDto;
import pl.web.instalook.model.Image;
import pl.web.instalook.repository.ImageRepository;

@Service
@AllArgsConstructor
public class ImageServiceImplement implements ImageService{

    private ImageRepository repository;

    @Override
    public void save(ImageDto imageDto) {
        Image image = new Image(imageDto.getDate(), imageDto.getImageName(), imageDto.getTitle(), imageDto.getDesc(), imageDto.getUser());
        repository.save(image);
    }
}
