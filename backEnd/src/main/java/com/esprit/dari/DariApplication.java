package com.esprit.dari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class DariApplication {

    public static void main(String[] args) {
        SpringApplication.run(DariApplication.class, args);
    }

}
