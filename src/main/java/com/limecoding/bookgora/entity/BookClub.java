package com.limecoding.bookgora.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class BookClub {
    @Id @GeneratedValue
    @Column(name = "bookclub_id")
    private Long id;
    private String name;
    private String place;
    private LocalDateTime meetingTime;
    private Integer currentPersonCount;
    private Integer maxPersonCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book bookInfo;
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "bookClub")
    private List<BookClubUser> bookClubUserList = new ArrayList<>();

    public BookClub(String name, String place, LocalDateTime meetingTime, Integer currentPersonCount, Integer maxPersonCount, Book bookInfo, String description) {
        this.name = name;
        this.place = place;
        this.meetingTime = meetingTime;
        this.currentPersonCount = currentPersonCount;
        this.maxPersonCount = maxPersonCount;
        this.bookInfo = bookInfo;
        this.description = description;
    }
}
