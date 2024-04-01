package com.limecoding.bookgora.entity;

import com.limecoding.bookgora.Dto.UserCreateDto;
import com.limecoding.bookgora.Dto.UserUpdateDto;
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

    public User of(UserCreateDto userCreateDto) {
        return new User(
                userCreateDto.getName(),
                userCreateDto.getNickname(),
                userCreateDto.getPhoneNumber(),
                userCreateDto.getPassword());
    }

    public void update(UserUpdateDto userUpdateDto) {
        this.name = userUpdateDto.getName();
        this.nickname = userUpdateDto.getNickname();
        this.phoneNumber = userUpdateDto.getPhoneNumber();
        this.password = userUpdateDto.getPassword();
    }
}
