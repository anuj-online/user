package com.codeverse.user.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "post")
@Data
@Accessors(chain = true)
public class PostEntity {

    @Id
    @GeneratedValue
    Long id;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UserEntity userEntity;
    private byte[] fileContent;
    private String fileName;
    private String postContent;
}
