package com.eprit.dari.services;

import com.eprit.dari.dao.UserDariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDariServiceImpl implements IUserDariService{

    @Autowired
    UserDariRepository userDariRepository;
}
