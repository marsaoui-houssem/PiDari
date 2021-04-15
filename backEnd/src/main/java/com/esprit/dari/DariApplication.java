package com.esprit.dari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class} )
public class DariApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DariApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws Exception {
//        Stream.of("T1", "T2", "T3").forEach(t -> {
//            taskRepository.save(new Task(null, "t"));
//
//        });
//        taskRepository.findAll().forEach(t -> {
//            System.out.println(t.getTaskName());
//        });
   // }
}