package com.ayhanunlu;

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
}
