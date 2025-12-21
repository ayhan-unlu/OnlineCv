package com.ayhanunlu.service.impl;

import com.ayhanunlu.data.dto.RegisterDto;
import com.ayhanunlu.data.entity.UserEntity;
import com.ayhanunlu.enums.Role;
import com.ayhanunlu.enums.Status;
import com.ayhanunlu.exception.UserAlreadyExistsException;
import com.ayhanunlu.repository.UserRepository;
import com.ayhanunlu.service.LoginAttemptService;
import com.ayhanunlu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ayhanunlu.enums.Role.ROLE_USER;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoginAttemptService loginAttemptService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoginAttemptService loginAttemptService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loginAttemptService = loginAttemptService;
    }

    @Override
    public void createDefaultAdmin() {
        if (userRepository.findByUsername("a").isEmpty()) {
            UserEntity defaultAdminEntity = new UserEntity();
            defaultAdminEntity.setUsername("a");
            defaultAdminEntity.setPassword(passwordEncoder.encode("a"));
            defaultAdminEntity.setRole(Role.ROLE_ADMIN);
            defaultAdminEntity.setStatus(Status.ACTIVE);
            defaultAdminEntity.setName("a");
            defaultAdminEntity.setSurname("a");
            defaultAdminEntity.setPhone("a");
            defaultAdminEntity.setFieldOfExperience("a");
            defaultAdminEntity.setExperienceYear(0);
            defaultAdminEntity.setMilitaryServiceFinished(true);
            defaultAdminEntity.setCvStorageMonth(12);
            userRepository.save(defaultAdminEntity);
            log.info("Default Admin is Created");
        }
    }

    @Override
    public void registerUser(RegisterDto registerDto) {
        if (isUsernameInUse(registerDto.getUsername())) {
            log.error("Username {} is already in use", registerDto.getUsername());
            throw new UserAlreadyExistsException("User Already Exists.");
        } else {
            UserEntity newUserEntity = new UserEntity();
            newUserEntity.setUsername(registerDto.getUsername());
            newUserEntity.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            newUserEntity.setRole(ROLE_USER);
            newUserEntity.setStatus(Status.ACTIVE);
            newUserEntity.setName(registerDto.getName());
            newUserEntity.setSurname(registerDto.getSurname());
            newUserEntity.setPhone(registerDto.getPhone());
            newUserEntity.setFieldOfExperience(registerDto.getFieldOfExperience());
            newUserEntity.setExperienceYear(registerDto.getExperienceYear());
            newUserEntity.setMilitaryServiceFinished(registerDto.isMilitaryServiceFinished());
            newUserEntity.setCvStorageMonth(registerDto.getCvStorageMonth());
            newUserEntity.setFailedLoginAttempts(0);
            userRepository.save(newUserEntity);
            log.info("New User {} has been registered.", newUserEntity.getUsername());
        }
    }

    @Override
    public UserEntity getLoggedInUserEntity(String username) {
        UserEntity loggedInUserEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        loggedInUserEntity.setPassword(null);
        return loggedInUserEntity;
    }

    @Override
    public List<UserEntity> getAllUsers(){
        List<UserEntity> userEntityList= new ArrayList<>();
        for(UserEntity userEntity : userRepository.findAll()){
            if(userEntity.getRole()==Role.ROLE_USER){
                userEntityList.add(userEntity);
            }
        }return userEntityList;
    }

    private boolean isUsernameInUse(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public void onLoginFailure(String username) {
        userRepository.findByUsername(username).ifPresent(userEntity -> {
            if (userEntity.getStatus() != Status.BLOCKED) {
                loginAttemptService.increaseFailedLoginAttempts(username);
            }
        });

    }


}
