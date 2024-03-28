package com.limecoding.bookgora.repository;

import com.limecoding.bookgora.entity.Book;
import com.limecoding.bookgora.entity.BookClub;
import com.limecoding.bookgora.entity.BookClubUser;
import com.limecoding.bookgora.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookClubRepository bookClubRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookClubUserRepository bookClubUserRepository;

    @Test
    void userRepositoryBasicTest() {

        // given
        User user = new User("memberName", "memberNickname", "010-5706-9516", "member");
        userRepository.save(user);

        // when
        List<User> userList = userRepository.findAll();

        // then
        User findUser = userList.get(0);

        Assertions.assertThat(findUser.getName()).isEqualTo("memberName");

    }

    @Test
    void userJoinBookClubTest() {
        // given
        User user = new User("memberName", "memberNickname", "010-5706-9516", "member");
        Book book = new Book("title", "author");
        LocalDateTime now = LocalDateTime.now();
        BookClub bookClub = BookClub.builder()
                .name("bookClubName")
                .place("bookClubPlace")
                .maxPersonCount(10)
                .currentPersonCount(0)
                .meetingTime(now)
                .bookInfo(book)
                .description("book description")
                .build();
        userRepository.save(user);
        bookRepository.save(book);
        bookClubRepository.save(bookClub);

        // when
        BookClubUser bookClubUser = new BookClubUser(bookClub, user, "member");
        bookClubUserRepository.save(bookClubUser);

        // then
        User findUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다."));

        Assertions.assertThat(findUser.getName()).isEqualTo("memberName");
        Assertions.assertThat(findUser.getBookClubUserList()).extracting("role").contains("member");
        String joinBookClubName = findUser.getBookClubUserList().get(0).getBookClub().getName();
        Assertions.assertThat(joinBookClubName).isEqualTo(bookClub.getName());
    }
}