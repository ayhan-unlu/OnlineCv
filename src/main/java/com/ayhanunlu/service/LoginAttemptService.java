package com.ayhanunlu.service;

import com.ayhanunlu.data.entity.UserEntity;

import java.util.Optional;

public interface LoginAttemptService {
    boolean isUserPresent(String username);
    boolean isUserActive(String username);
    boolean isPasswordCorrect(String username, String password);
}
