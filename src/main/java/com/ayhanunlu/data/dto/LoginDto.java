package com.ayhanunlu.data.dto;

import com.ayhanunlu.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoginDto {
    private String username;
    private Status status;
    private int failedLoginAttempts;
    private String errorMessage;
}
