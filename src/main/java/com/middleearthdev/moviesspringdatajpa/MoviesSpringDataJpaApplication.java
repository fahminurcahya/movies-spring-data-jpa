package com.middleearthdev.moviesspringdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviesSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesSpringDataJpaApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("test");
        };
    }
}
