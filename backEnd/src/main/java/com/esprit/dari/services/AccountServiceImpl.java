package com.esprit.dari.services;

import com.esprit.dari.dao.RoleRepository;
import com.esprit.dari.dao.UserDariRepository;
import com.esprit.dari.entities.RoleDari;
import com.esprit.dari.entities.UserDari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserDariRepository userDariRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDari saveUser(UserDari user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDariRepository.save(user);
    }

    @Override
    public RoleDari saveRole(RoleDari role)
    {
        return roleRepository.save(role);

    }

    @Override
    public UserDari loadUserByUsername(String userName)
    {
        return userDariRepository.findByUsername(userName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        UserDari userDari = userDariRepository.findByUsername(username);
        RoleDari role = roleRepository.findByName(roleName);
        //puisque la methode Transactionnel ilajout le role ala table
        userDari.getRoleDaris().add(role);

    }
}
