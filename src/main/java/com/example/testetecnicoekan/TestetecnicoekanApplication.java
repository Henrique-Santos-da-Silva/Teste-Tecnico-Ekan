package com.example.testetecnicoekan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestetecnicoekanApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestetecnicoekanApplication.class, args);
    }

}
