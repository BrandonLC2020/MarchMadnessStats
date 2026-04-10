package com.blc.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("CBB_API_KEY", dotenv.get("CBB_API_KEY"));
        SpringApplication.run(BackendApplication.class, args);
    }

}