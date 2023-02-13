package com.codeverse.user.controller;

import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class User {
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private LocalDate dob;
    private String college;
    private String branch;
    private boolean laptop;
    private String laptopBrand;
    private String resetToken;
}
