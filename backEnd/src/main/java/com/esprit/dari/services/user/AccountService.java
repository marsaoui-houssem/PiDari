package com.esprit.dari.services.user;

import com.esprit.dari.controller.dto.RegisterForm;
import com.esprit.dari.entities.userentity.RoleDari;
import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.security.core.Authentication;

import javax.mail.MessagingException;
import java.util.List;


public interface AccountService  {
    public UserDari saveUser(UserDari user);
    public RoleDari saveRole(RoleDari role);
    public UserDari loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public List<UserDari> getAllUser();
    public void deleteUserById(long userId);
    public void updateMotDePasse(String email, String password);
    public UserDari loadUserByEmail(String email);

    void resetPassword(RegisterForm userForm) throws MessagingException;

    void comfirm(Authentication authentication);

    UserDari register(RegisterForm userForm) throws MessagingException;
}
