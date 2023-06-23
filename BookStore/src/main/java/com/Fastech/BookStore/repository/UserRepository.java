package com.Fastech.BookStore.repository;

import com.Fastech.BookStore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
 User findByUsername(String username);
}
