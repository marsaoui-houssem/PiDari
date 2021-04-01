package com.esprit.dari.services.user;

import org.aspectj.lang.JoinPoint;
import org.springframework.security.core.Authentication;

public interface TrasabilityService {
    void save(JoinPoint joinPoint, Authentication authentication);
}
