package kosa.edu.YogitNet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class YogitNetApplication {

    public static void main(String[] args) {
        SpringApplication.run(YogitNetApplication.class, args);
    }

}