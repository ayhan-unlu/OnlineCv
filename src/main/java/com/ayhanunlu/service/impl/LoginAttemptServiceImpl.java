package com.ayhanunlu.service.impl;

import com.ayhanunlu.data.entity.UserEntity;
import com.ayhanunlu.enums.Status;
import com.ayhanunlu.repository.UserRepository;
import com.ayhanunlu.service.LoginAttemptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginAttemptServiceImpl implements LoginAttemptService {

    private final UserRepository userRepository;

    public LoginAttemptServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* @Override
     public boolean isUserPresent(String username) {
         return userRepository.findByUsername(username).isPresent();
     }


     @Override
     public boolean isPasswordCorrect(String username, String password) {
         return false;
     }
    */
    @Override
    public void increaseFailedLoginAttempts(String username) {
        userRepository.findByUsername(username).ifPresent(foundUserEntity -> {
            int increasedFailedLoginAttempts = foundUserEntity.getFailedLoginAttempts() + 1;
            foundUserEntity.setFailedLoginAttempts(increasedFailedLoginAttempts);
            if (increasedFailedLoginAttempts >= 3) {
                foundUserEntity.setStatus(Status.BLOCKED);
            }
            userRepository.save(foundUserEntity);
        });
    }

    @Override
    public void resetFailedLoginAttempts(String username) {
        userRepository.findByUsername(username).ifPresent(foundUserEntity ->
        {
            foundUserEntity.setFailedLoginAttempts(0);
            userRepository.save(foundUserEntity);
        });
    }

}
