package com.Fastech.BookStore.controller;

import com.Fastech.BookStore.model.Book;
import com.Fastech.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AddBookController {
    private BookRepository bookRepository;

    @Autowired
    public AddBookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/Addbooks")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        if (book.getTitle() == null || book.getAuthor() == null || book.getISBN() == null || book.getUrl() == null || book.getPrice() <= 0.0) {
            return ResponseEntity.badRequest().body("Incorrect or missing field");
        } else {
            bookRepository.save(book);
            return ResponseEntity.ok("Book added");
        }
    }

}
