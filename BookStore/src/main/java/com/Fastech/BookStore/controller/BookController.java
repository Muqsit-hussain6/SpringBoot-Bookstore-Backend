package com.Fastech.BookStore.controller;

import com.Fastech.BookStore.dto.BookDto;
import com.Fastech.BookStore.model.Book;
import com.Fastech.BookStore.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/search")
    public List<BookDto> searchBooks(@RequestParam("query") String searchQuery) {
        List<Book> books = bookRepository.searchBooks(searchQuery);
        return getBookDtos(books);

    }

    @GetMapping("/getbooks")
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return getBookDtos(books);
    }

    private List<BookDto> getBookDtos(List<Book> books) {
        List<BookDto> bookDtos = new ArrayList<>();

        for (Book book : books) {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book, bookDto);
            bookDtos.add(bookDto);
        }

        return bookDtos;
    }

    @GetMapping("/{title}")
    public ResponseEntity<BookDto> getBook(@PathVariable String title){
        Book book= bookRepository.findByTitle(title);
        if(book!=null)
        {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book,bookDto);
            return ResponseEntity.ok(bookDto);
        }
        return ResponseEntity.notFound().build();

    }


}
