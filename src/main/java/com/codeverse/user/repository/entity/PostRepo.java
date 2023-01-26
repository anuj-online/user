package com.codeverse.user.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<PostEntity, Long> {

//    List<PostEntity> findAllById(Long id);
}
