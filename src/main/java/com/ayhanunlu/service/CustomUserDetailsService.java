package com.ayhanunlu.service;

import com.ayhanunlu.data.entity.UserEntity;
import com.ayhanunlu.enums.Status;
import com.ayhanunlu.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<UserEntity> foundUserEntity = userRepository.findByUsername(username);
        if(foundUserEntity.isEmpty()){
            log.warn("Username {} not found", username);
            throw new UsernameNotFoundException(username);
        }else if(foundUserEntity.get().getStatus()== Status.BLOCKED){
            log.warn("Username {} is blocked", username);
            throw new LockedException(username);
        }
        UserEntity currentUserEntity = foundUserEntity.get();
        log.info("User {} Details fetched successfully.", currentUserEntity.getUsername());
        return new User(currentUserEntity.getUsername(), currentUserEntity.getPassword(),true,true,true,true, List.of(new SimpleGrantedAuthority(currentUserEntity.getRole().name())));
    }
}
