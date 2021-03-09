package com.esprit.dari.services;

import com.esprit.dari.entities.RoleDari;
import com.esprit.dari.entities.UserDari;

import java.util.List;


public interface AccountService  {
    public UserDari saveUser(UserDari user);
    public RoleDari saveRole(RoleDari role);
    public UserDari loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public List<UserDari> getAllUser();
    public void deleteUserById(int userId);
    public void updateMotDePasse(String password);
}
