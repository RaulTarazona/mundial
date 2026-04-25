package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.mundial.app")
@EnableMongoRepositories(basePackages = "com.mundial.app.Repositorio")
public class MundialApplication {
    public static void main(String[] args) {
        SpringApplication.run(MundialApplication.class, args);
    }
}