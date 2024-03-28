package com.limecoding.bookgora.repository;

import com.limecoding.bookgora.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
