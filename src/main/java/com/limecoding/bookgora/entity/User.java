package com.limecoding.bookgora.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String password;


    @OneToMany(mappedBy = "user")
    private List<BookClubUser> BookClubUserList = new ArrayList<>();

    public User(String name, String nickname, String phoneNumber, String password) {
        this.name = name;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
