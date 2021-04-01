package com.esprit.dari.services.user.impl;


import com.esprit.dari.dao.userrepository.TrasabilityRepository;
import com.esprit.dari.entities.userentity.Trasability;
import com.esprit.dari.services.user.TrasabilityService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Service
public class TrasabilityServiceImpl implements TrasabilityService {

    private final TrasabilityRepository trasabilityRepository;

    public TrasabilityServiceImpl(TrasabilityRepository trasabilityRepository) {
        this.trasabilityRepository = trasabilityRepository;
    }

    @Override
    public void save(JoinPoint joinPoint, Authentication authentication) {
        Trasability trasability = new Trasability();
        trasability.setDate(LocalDateTime.now());
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        trasability.setRequest(method.getName());
        if(authentication != null){
            String userName = (String) authentication.getPrincipal();
            trasability.setUser(userName);
        }
        trasabilityRepository.save(trasability);

    }
}
