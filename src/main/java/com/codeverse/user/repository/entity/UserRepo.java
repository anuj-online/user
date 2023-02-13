package com.codeverse.user.repository.entity;

import com.codeverse.user.controller.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByEmail(String emailId);

    UserEntity findById(String id);

    public UserEntity findByFullName(String username);

}

