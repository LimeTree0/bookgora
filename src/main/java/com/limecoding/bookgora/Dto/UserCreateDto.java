package com.limecoding.bookgora.Dto;

import com.limecoding.bookgora.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateDto {

    private Long id;
    private String name;
    private String nickname;
    private String phoneNumber;
    private String password;

    public User toEntity() {
        return new User(
                this.getName(),
                this.getNickname(),
                this.getPhoneNumber(),
                this.getPassword());
    }
}
