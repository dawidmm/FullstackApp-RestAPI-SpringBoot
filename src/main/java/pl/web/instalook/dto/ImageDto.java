package pl.web.instalook.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.web.instalook.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

    private String date;
    private String imageName;
    private String title;
    private String desc;
    private User user;
}
