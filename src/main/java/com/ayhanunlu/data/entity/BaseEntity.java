package com.ayhanunlu.data.entity;

import com.ayhanunlu.enums.Role;
import com.ayhanunlu.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;

    @Column(name="failed_login_attempts")
    private int failedLoginAttempts;
}
