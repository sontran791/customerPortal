package com.java.customerportal.listener;

import com.java.customerportal.dao.User;
import com.java.customerportal.dao.UserPrincipal;
import com.java.customerportal.service.LoginAttemptService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthenticationSuccessListener {
    private final LoginAttemptService loginAttemptService;

    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
        Object principal = event.getAuthentication().getPrincipal();
        if(principal instanceof User) {
            UserPrincipal user = (UserPrincipal) event.getAuthentication().getPrincipal();
            loginAttemptService.evictUserFromLoginAttemptCache(user.getUsername());
        }
    }
}
