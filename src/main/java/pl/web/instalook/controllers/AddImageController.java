package pl.web.instalook.controllers;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import pl.web.instalook.dto.ImageDto;
import pl.web.instalook.model.User;
import pl.web.instalook.repository.UserRepository;
import pl.web.instalook.service.ImageService;
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
    public String addImage(@RequestParam("image") MultipartFile multipartFile, ImageDto image) {

        try {

            saveImage(image, multipartFile);
        }
        catch (IOException e) {

            return "redirect:/add?file";
        }

        return "index";
    }

    private void saveImage(ImageDto image, MultipartFile multipartFile) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        User user = userRepository.findByLogin(username);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();

        String name = multipartFile.getOriginalFilename();
        StringBuilder bulidName = new StringBuilder(name);
        String end = bulidName.substring(bulidName.indexOf("."));

        String endName = System.currentTimeMillis() + end;

        Path path = Paths.get("C:/Users/Dawid/Desktop/instalook/src/main/resources/templates/img/" + endName);
        Files.write(path, multipartFile.getBytes());

        image.setImageName(endName);
        image.setDate(dtf.format(localDate));
        image.setUser(user);

        imageService.save(image);
    }
}
