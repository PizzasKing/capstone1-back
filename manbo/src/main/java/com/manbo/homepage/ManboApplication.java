package com.manbo.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.manbo.homepage.repository")
@EntityScan(basePackages = "com.manbo.homepage.entity")
public class ManboApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManboApplication.class, args);
    }
}

