package com.limecoding.bookgora.Dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserUpdateDto {

    private String name;
    private String nickname;
    private String phoneNumber;
    private String password;

    public UserUpdateDto(String name, String nickname, String phoneNumber, String password) {
        this.name = name;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
