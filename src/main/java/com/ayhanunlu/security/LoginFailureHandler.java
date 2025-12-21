package com.ayhanunlu.security;

import com.ayhanunlu.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private final UserService userService;

    public LoginFailureHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AuthenticationException authenticationException
    ) throws IOException {
        String username = httpServletRequest.getParameter("username");

        if (authenticationException instanceof org.springframework.security.authentication.LockedException) {
            httpServletResponse.sendRedirect("/login?blocked=true&username="+username);
            return;
        }
        if(authenticationException instanceof org.springframework.security.core.userdetails.UsernameNotFoundException){
            httpServletResponse.sendRedirect("/login?error=true");
            return;
        }
        userService.onLoginFailure(username);
        httpServletResponse.sendRedirect("/login?error=true&username=" + username);
    }
}
