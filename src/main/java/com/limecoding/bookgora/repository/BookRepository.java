package com.limecoding.bookgora.repository;

import com.limecoding.bookgora.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
