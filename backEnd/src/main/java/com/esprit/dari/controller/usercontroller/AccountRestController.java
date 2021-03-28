package com.esprit.dari.controller;


import com.esprit.dari.controller.dto.RegisterForm;
import com.esprit.dari.entities.userentity.UserDari;
import com.esprit.dari.services.userservice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AccountRestController {


    @Autowired
    private AccountService accountService;











    @PostMapping("/register")
    public UserDari register(@RequestBody RegisterForm userForm){
        if (!userForm.getPassword().equals(userForm.getRepassword()))
            throw new RuntimeException("you must confirm your password");

        UserDari username=accountService.loadUserByUsername(userForm.getUsername());
        if (username!=null) throw new RuntimeException("this User is already exists");
        UserDari usermail=accountService.loadUserByEmail(userForm.getEmail());
        UserDari userDari = new UserDari();
        userDari.setEmail(userForm.getEmail());
        userDari.setUsername(userForm.getUsername());
        userDari.setPassword(userForm.getPassword());
        accountService.saveUser(userDari);
        accountService.addRoleToUser(userForm.getUsername(),"USER");
        return userDari;
    }

    // URL : http://localhost:8081/dari/getAllUsers
    @GetMapping(value = "/getAllUsers")
    @ResponseBody
    public List<UserDari> getAllUser() {
        return accountService.getAllUser();
    }

    // URL : http://localhost:8081/dari/deleteUserById/1
    @DeleteMapping("/deleteUserById/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable("id") int UserId) {
        accountService.deleteUserById(UserId);
    }

  //  Modifier mdp : http://localhost:8081/dari/updatepassword/1/password
    @PutMapping(value = "/updatepassword/{id}/{password}")
    @ResponseBody
    public void updateMotDePasse(@PathVariable("password") String password, @PathVariable("id") int userId) {
        accountService.updateMotDePasse(userId,password);

    }


}
