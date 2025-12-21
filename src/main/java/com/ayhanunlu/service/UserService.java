package com.ayhanunlu.service;

import com.ayhanunlu.data.dto.RegisterDto;
import com.ayhanunlu.data.entity.UserEntity;

import java.util.List;

public interface UserService {
    void createDefaultAdmin();
    void registerUser(RegisterDto registerDto);
    void onLoginFailure(String username);
    UserEntity getLoggedInUserEntity(String username);
    List<UserEntity> getAllUsers();
}
