package pl.web.instalook.service;

import org.springframework.stereotype.Service;
import pl.web.instalook.dto.ImageDto;
import pl.web.instalook.repository.ImageRepository;


public interface ImageService {

    void save(ImageDto imageDto);
}
