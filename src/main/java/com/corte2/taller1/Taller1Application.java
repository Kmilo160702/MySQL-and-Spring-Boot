package com.corte2.taller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Taller1Application {

    @Autowired
    private CustomerController customerController;

    public static void main(String[] args) {
        SpringApplication.run(Taller1Application.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            customerController.executeQuery();
        };
    }
}
