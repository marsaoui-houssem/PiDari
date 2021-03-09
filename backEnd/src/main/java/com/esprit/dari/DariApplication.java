package com.esprit.dari;

import com.esprit.dari.dao.TaskRepository;
import com.esprit.dari.entities.RoleDari;
import com.esprit.dari.entities.Task;
import com.esprit.dari.entities.UserDari;
import com.esprit.dari.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class DariApplication implements CommandLineRunner {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(DariApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
      accountService.saveUser(new UserDari(null,"admin","admin",null));
      accountService.saveUser(new UserDari(null,"user","user",null));
        accountService.saveRole(new RoleDari(null,"ADMIN"));
        accountService.saveRole(new RoleDari(null,"USER"));
        accountService.addRoleToUser("admin","ADMIN");
        accountService.addRoleToUser("admin","USER");
        accountService.addRoleToUser("User","USER");
        Stream.of("T1", "T2", "T3").forEach(t -> {
            taskRepository.save(new Task(null, "t"));

        });
        taskRepository.findAll().forEach(t -> {
            System.out.println(t.getTaskName());
        });

    }


    //    @Override
//    public void run(String... args) throws Exception {
////        Stream.of("T1", "T2", "T3").forEach(t -> {
////            taskRepository.save(new Task(null, "t"));
////
////        });
////        taskRepository.findAll().forEach(t -> {
////            System.out.println(t.getTaskName());
////        });
//    }
}