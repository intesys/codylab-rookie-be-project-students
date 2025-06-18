package it.intesys.codylab.rookie.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RookieProject {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RookieProject.class);
        application.run(args);
    }
}
