package com.example.springredis.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@RedisHash(timeToLive = 60)
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

    @Indexed
    private String firstName;

    private String lastName;

    private List<Item> items;

    private List<String> friends;
}
