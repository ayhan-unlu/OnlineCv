package com.ayhanunlu.security;

import com.ayhanunlu.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    public final RoleBasedAuthenticationSuccessHandler roleBasedAuthenticationSuccessHandler;
    public final LoginFailureHandler loginFailureHandler;

    public SecurityConfig(RoleBasedAuthenticationSuccessHandler roleBasedAuthenticationSuccessHandler, LoginFailureHandler loginFailureHandler) {
        this.roleBasedAuthenticationSuccessHandler = roleBasedAuthenticationSuccessHandler;
        this.loginFailureHandler = loginFailureHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/admin_dashboard").hasRole("ADMIN")
                        .requestMatchers("/user_dashboard").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                                .loginPage("/login")
                                .successHandler(roleBasedAuthenticationSuccessHandler)
                                .failureHandler(loginFailureHandler)
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                );
        return httpSecurity.build();
    }
}
