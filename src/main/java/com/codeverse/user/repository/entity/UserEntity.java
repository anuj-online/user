package com.codeverse.user.repository.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "user_details")
@Data
@Accessors(chain = true)
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private String college;
    @Column(nullable = false)
    private String branch;
    @Column(nullable = false)
    private boolean laptop;

    private String laptopBrand;
    @Column(nullable = false)
    private LocalDateTime registrationTime= LocalDateTime.now();


}
