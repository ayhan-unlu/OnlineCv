package com.ayhanunlu.data.dto;

import com.ayhanunlu.enums.Role;
import com.ayhanunlu.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterDto {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private String fieldOfExperience;
    private int experienceYear;
    private boolean militaryServiceFinished;
    private int cvStorageMonth;

}
