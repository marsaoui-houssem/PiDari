package com.esprit.dari.controller;


import com.esprit.dari.entities.UserDari;
import com.esprit.dari.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountRestController {

    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public UserDari register(@RequestBody RegisterForm userForm){
        if (!userForm.getPassword().equals(userForm.getRepassword()))
            throw new RuntimeException("you must confirm your password");

        UserDari users=accountService.loadUserByUsername(userForm.getUsername());
        if (users!=null) throw new RuntimeException("this User is already exists");

        UserDari userDari = new UserDari();
        userDari.setUsername(userForm.getUsername());
        userDari.setPassword(userForm.getPassword());
        accountService.saveUser(userDari);
        accountService.addRoleToUser(userForm.getUsername(),"USER");
        return userDari;
    }

}
