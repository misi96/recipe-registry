package com.reciperegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is the main class of the application.
 */
@EnableJpaRepositories
@SpringBootApplication
public class Main {
//    /**
//     * This is the empty constructor of the class.
//     */
//    private Main() {
//    }

    /**
     * This is the slf4j logger of the application.
     */
    private static Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * This is the main method of the application.
     *
     * @param args the arguments of the main method
     */
    public static void main(final String[] args) {
        log.info("Called - main function");

        SpringApplication.run(Main.class, args);
    }
}
