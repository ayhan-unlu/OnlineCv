package com.ayhanunlu.controller;

import com.ayhanunlu.data.dto.LoginDto;
import com.ayhanunlu.data.dto.RegisterDto;
import com.ayhanunlu.exception.BusinessException;
import com.ayhanunlu.repository.UserRepository;
import com.ayhanunlu.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThymeleafController {

    private final UserService userService;
    private final UserRepository userRepository;

    public ThymeleafController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    /// GET ROOT
    /// http://localhost:8080
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }


    /// GET LOGIN
    /// http://localhost:8080/login
    @GetMapping("/login")
    public String login(
            @RequestParam(required = false) String registered,
            @RequestParam(required = false) String error,
            Model model
    ) {
        LoginDto loginDto = new LoginDto();
        if (registered != null) {
            loginDto.setErrorMessage("Registration successful. Please Log in.");
        }
        if (error != null) {
            loginDto.setErrorMessage("Invalid username or password. Please try again.");
        }
        model.addAttribute("loginDto", loginDto);
        return "login";
    }

    /// GET ADMIN DASHBOARD
    /// http://localhost:8080/admin_dashboard
    @GetMapping("/admin_dashboard")
    public String adminDashboard(@AuthenticationPrincipal UserDetails userDetails) {
        return "admin_dashboard";
    }

    /// GET USER DASHBOARD
    /// http://localhost:8080/user_dashboard
    @GetMapping("/user_dashboard")
    public String userDashboard(@AuthenticationPrincipal UserDetails userDetails) {
        return "user_dashboard";
    }

    /// GET REGISTER
    ///  http://localhost:8080/register
    @GetMapping("/register")
    public String register(Model model) {
//        model.addAttribute("registerDto", new RegisterDto());
        return "register";
    }

    /// MODELATTRIBUTE REGISTERDTO
    @ModelAttribute("registerForm")
    public RegisterDto form() {
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
