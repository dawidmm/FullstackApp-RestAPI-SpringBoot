package pl.web.instalook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class InstalookApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstalookApplication.class, args);
    }

}
