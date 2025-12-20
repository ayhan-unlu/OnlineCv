package com.ayhanunlu.service;

import com.ayhanunlu.data.entity.UserEntity;

import java.util.Optional;

public interface LoginAttemptService {
  void increaseFailedLoginAttempts(String username);
  void resetFailedLoginAttempts(String username);
}
