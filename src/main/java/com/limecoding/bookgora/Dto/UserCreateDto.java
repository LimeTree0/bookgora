package com.limecoding.bookgora.Dto;

import com.limecoding.bookgora.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserCreateDto {

    private String name;        // 이름
    private String nickname;    // 닉네임
    private String phoneNumber; // 전화번호
    private String password;    // 비밀번호

    public User toEntity() {
        return new User(
                this.getName(),
                this.getNickname(),
                this.getPhoneNumber(),
                this.getPassword());
    }
}
