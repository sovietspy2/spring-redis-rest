package com.example.springredis.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@RedisHash
public class User implements Serializable {

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    public enum Role {
        REGULAR, ADMIN, MODERATOR
    }

    @Id
    private Integer id;

    private Gender gender;

    private Role role;

    private Integer level;

    private LocalDateTime createDate;

    private String firstName;

    private String lastName;





}
