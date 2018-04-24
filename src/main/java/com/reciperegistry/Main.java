package com.reciperegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Called - main function");

        SpringApplication.run(Main.class, args);
    }
}
