package com.esprit.dari.services;

import com.esprit.dari.entities.RoleDari;
import com.esprit.dari.entities.UserDari;


public interface AccountService  {
    public UserDari saveUser(UserDari user);
    public RoleDari saveRole(RoleDari role);
    public UserDari loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
}
