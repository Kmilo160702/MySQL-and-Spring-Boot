package com.corte2.taller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.corte2.taller1.controllers.EnterpriseController;

@SpringBootApplication
public class Taller1Application {

    @Autowired
    private EnterpriseController EnterpriseController;

    public static void main(String[] args) {
        SpringApplication.run(Taller1Application.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            EnterpriseController.executeQuery();
        };
    }
}
