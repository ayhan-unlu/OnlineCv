package com.ayhanunlu.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication
    ) throws IOException, ServletException {
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                httpServletResponse.sendRedirect("/admin_dashboard");
                return;
            }
            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                httpServletResponse.sendRedirect("/user_dashboard");
                return;
            }
        }
        httpServletResponse.sendRedirect("/login?error=true");
    }
}
