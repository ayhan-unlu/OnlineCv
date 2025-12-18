package com.ayhanunlu;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    /// GET LOGIN
    /// http://localhost:8080/login
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /// GET ADMIN DASHBOARD
    /// http://localhost:8080/admin_dashboard
    @GetMapping("/admin_dashboard")
    public String adminDashboard(@AuthenticationPrincipal UserDetails userDetails){
        return "admin_dashboard";
    }



}
