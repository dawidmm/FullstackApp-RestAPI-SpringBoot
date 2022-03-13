package pl.web.instalook.controllers;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.web.instalook.dto.ImageDto;
import pl.web.instalook.model.Image;
import pl.web.instalook.model.User;
import pl.web.instalook.repository.ImageRepository;
import pl.web.instalook.repository.UserRepository;
import pl.web.instalook.service.ImageService;
import pl.web.instalook.service.ImageServiceImplement;
import pl.web.instalook.service.UserServiceImplement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@AllArgsConstructor
@RequestMapping("/add")
public class AddImageController {

    private UserRepository userRepository;
    private ImageService imageService;

    @ModelAttribute("instalook_image")
    private ImageDto imageDto(){
        return new ImageDto();
    }

    @GetMapping
    public String displayAddImage(){
        return "add";
    }

    @PostMapping
    public String addImage(@RequestParam("image") MultipartFile multipartFile, ImageDto image) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        User user = userRepository.findByLogin(username);

        image.setUser(user);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();

        image.setDate(dtf.format(localDate));

        String name = multipartFile.getOriginalFilename();
        StringBuilder bulidName = new StringBuilder(name);
        String endName = System.currentTimeMillis() + bulidName.substring(bulidName.indexOf("."));

        Path path = Paths.get("C:/Users/Dawid/Desktop/instalook/src/main/resources/templates/img/" + endName);
        Files.write(path, multipartFile.getBytes());

        image.setImageName(endName);

        imageService.save(image);

        return "add";
    }
}
