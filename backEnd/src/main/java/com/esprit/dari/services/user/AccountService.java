package com.esprit.dari.services.userservice;

import com.esprit.dari.entities.userentity.RoleDari;
import com.esprit.dari.entities.userentity.UserDari;

import java.util.List;


public interface AccountService  {
    public UserDari saveUser(UserDari user);
    public RoleDari saveRole(RoleDari role);
    public UserDari loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public List<UserDari> getAllUser();
    public void deleteUserById(long userId);
    public void updateMotDePasse(long userId, String password);
    public UserDari loadUserByEmail(String email);

}
