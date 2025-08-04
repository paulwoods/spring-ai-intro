package org.mrpaulwoods.springaiintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.mrpaulwoods.springaiintro.${sec}")
public class SpringAiIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiIntroApplication.class, args);
    }

}
