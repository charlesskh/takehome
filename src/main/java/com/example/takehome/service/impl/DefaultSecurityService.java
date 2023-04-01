package com.example.takehome.service.impl;

import com.example.takehome.service.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("securityService")
public class DefaultSecurityService implements SecurityService {

    public String currentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        if(name == "anonymousUser") {
            return null;
        }
        return name;
    }

    public boolean notSignedIn(){
        return currentUsername() == null;
    }

}
