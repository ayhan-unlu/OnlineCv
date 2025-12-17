package com.ayhanunlu.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{


    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "field_of_experience")
    private String fieldOfExperience;

    @Column(name = "experienceYear")
    private int experienceYear;

    @Column(name = "military_service_finished")
    private boolean militaryServiceFinished;

    @Column(name = "cv_storage_month")
    private int cvStorageMonth;

}
