package com.ayhanunlu.service.impl;

import com.ayhanunlu.data.entity.UserEntity;
import com.ayhanunlu.enums.Role;
import com.ayhanunlu.enums.Status;
import com.ayhanunlu.repository.UserRepository;
import com.ayhanunlu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createDefaultAdmin(){
        if(userRepository.findByUsername("a").isEmpty()){
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

}
