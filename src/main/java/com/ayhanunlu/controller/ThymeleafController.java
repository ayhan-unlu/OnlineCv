package com.ayhanunlu.controller;

import com.ayhanunlu.data.dto.RegisterDto;
import com.ayhanunlu.exception.BusinessException;
import com.ayhanunlu.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThymeleafController {

    private final UserService userService;

    public ThymeleafController(UserService userService) {
        this.userService = userService;
    }

    /// GET LOGIN
    /// http://localhost:8080/login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /// GET ADMIN DASHBOARD
    /// http://localhost:8080/admin_dashboard
    @GetMapping("/admin_dashboard")
    public String adminDashboard(@AuthenticationPrincipal UserDetails userDetails) {
        return "admin_dashboard";
    }

    /// GET REGISTER
    ///  http://localhost:8080/register
    @GetMapping("/register")
    public String register(Model model) {
//        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    /// MODELATTRIBUTE REGISTERDTO
    @ModelAttribute("form")
    public RegisterDto form(){
        return new RegisterDto();
    }
    /// POST REGISTER
    /// http://localhost:8080/register
    @PostMapping("/register")
    public String postRegister(@ModelAttribute RegisterDto registerDto, Model model) {
        userService.registerUser(registerDto);
            return "redirect:/login?registered=true";
    }


}
