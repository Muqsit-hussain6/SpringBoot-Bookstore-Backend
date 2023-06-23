package com.Fastech.BookStore.repository;

import com.Fastech.BookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:searchQuery% OR b.author LIKE %:searchQuery%")
    List<Book> searchBooks(String searchQuery);

    List<Book> findAll();
    Book findByTitle(String title);
}
