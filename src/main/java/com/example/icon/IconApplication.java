package com.example.icon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IconApplication {

    public static void main(String[] args) {
        SpringApplication.run(IconApplication.class, args);
    }

}
