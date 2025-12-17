package com.ayhanunlu.config;

import com.ayhanunlu.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class DefaultAdminInitializer {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initializeDefaultAdmin(){
        userService.createDefaultAdmin();
    }
}
