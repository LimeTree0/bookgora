package com.limecoding.bookgora.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BookClubUser {

    @Id
    @GeneratedValue
    private Long id;

    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookclub_id")
    private BookClub bookClub;

    public BookClubUser(BookClub bookClub, User user, String role) {
        this.role = role;
        this.user = user;
        this.bookClub = bookClub;
        bookClub.getBookClubUserList().add(this);
        user.getBookClubUserList().add(this);
    }
}


