package com.esprit.dari.services.userservice;

import com.esprit.dari.dao.userrepository.RoleRepository;
import com.esprit.dari.dao.userrepository.UserDariRepository;
import com.esprit.dari.entities.userentity.RoleDari;
import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Override
    public List<UserDari> getAllUser() {
        return (List<UserDari>) userDariRepository.findAll();
    }


    @Override
    public void deleteUserById(long userId) {
        userDariRepository.deleteById(userId);
    }

    @Override
    public void updateMotDePasse(long userId, String password) {
        UserDari userDari = userDariRepository.findById(userId).get();
        userDari.setPassword(password);
        userDariRepository.save(userDari);
    }

    @Override
    public UserDari loadUserByEmail(String email) {
        return userDariRepository.findByEmail(email);
    }


//    @Override
//    public void updatefirstNameAndlastNameAndnumTelById(String firstName, String lastName, String numTel, int employeId) {
//        User user = userRepository.findById(employeId).get();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setNumTel(numTel);
//        userRepository.save(user);
//    }
}
