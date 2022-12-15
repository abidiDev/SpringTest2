package com.example.testt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TestTApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTApplication.class, args);
    }

}
