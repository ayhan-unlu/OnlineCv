package com.ayhanunlu.security;

import com.ayhanunlu.service.LoginAttemptService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Slf4j
@Component
public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final LoginAttemptService loginAttemptService;

    public RoleBasedAuthenticationSuccessHandler(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication
    ) throws IOException, ServletException {
        loginAttemptService.resetFailedLoginAttempts(authentication.getName());
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            if ("ROLE_ADMIN".equals(grantedAuthority.getAuthority())) {
                httpServletResponse.sendRedirect("/admin_dashboard");
                log.info("Admin {} successfully logged in.", authentication.getName());
                return;
            }

            if ("ROLE_USER".equals(grantedAuthority.getAuthority())) {
                httpServletResponse.sendRedirect("/user_dashboard");
                log.info("User {} successfully logged in.", authentication.getName());
                return;
            }
        }
        httpServletResponse.sendRedirect("/login?error=true");
        log.error("Login failed for user {} on authentication",authentication.getName());
    }
}
