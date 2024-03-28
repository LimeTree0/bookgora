package com.limecoding.bookgora.repository;

import com.limecoding.bookgora.entity.Book;
import com.limecoding.bookgora.entity.BookClub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookClubRepositoryTest {

    @Autowired
    BookClubRepository bookClubRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    void bookClubRepositoryBasicTest() {

        // given
        LocalDateTime localDateTime = LocalDateTime.now();
        Book book = new Book("title", "author");

        bookRepository.save(book);

        BookClub bookClub = new BookClub("bookClubName","bookClubPlace", localDateTime, 0, 10, book, "book description");
        bookClubRepository.save(bookClub);

        // when
        List<BookClub> bookClubList = bookClubRepository.findAll();

        // then
        BookClub findBookClub = bookClubList.get(0);

        Assertions.assertThat(findBookClub.getName()).isEqualTo("bookClubName");
        Assertions.assertThat(findBookClub.getBookClubUserList()).isEmpty();

    }

    @Test
    void bookClubRepositoryBasicTest2() {

        // given
        LocalDateTime localDateTime = LocalDateTime.now();
        Book book = new Book("title", "author");

        bookRepository.save(book);

        BookClub bookClub = BookClub.builder()
                .name("bookClubName")
                .place("bookClubPlace")
                .maxPersonCount(10)
                .currentPersonCount(0)
                .meetingTime(localDateTime)
                .bookInfo(book)
                .description("book description")
                .build();
        bookClubRepository.save(bookClub);

        // when
        List<BookClub> bookClubList = bookClubRepository.findAll();

        // then
        BookClub findBookClub = bookClubList.get(0);

        Assertions.assertThat(findBookClub.getName()).isEqualTo("bookClubName");
        Assertions.assertThat(findBookClub.getBookClubUserList()).isEmpty();

    }
}