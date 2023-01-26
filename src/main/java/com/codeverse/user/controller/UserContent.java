package com.codeverse.user.controller;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserContent {
    private Long id;
    private String content;
    private MultipartFile file;
}
