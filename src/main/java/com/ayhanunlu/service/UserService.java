package com.ayhanunlu.service;

import com.ayhanunlu.data.dto.RegisterDto;

public interface UserService {
    void createDefaultAdmin();
    void registerUser(RegisterDto registerDto);
}
