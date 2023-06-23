package com.Fastech.BookStore.controller;

import com.Fastech.BookStore.dto.WishlistDto;
import com.Fastech.BookStore.dto.WishlistRemoveDTO;
import com.Fastech.BookStore.model.Book;
import com.Fastech.BookStore.model.User;
import com.Fastech.BookStore.repository.BookRepository;
import com.Fastech.BookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistController {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public WishlistController(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/wishlist/add")
    public ResponseEntity<String> addToWishlist(@RequestBody WishlistDto wishlistDto) {
        // Retrieve the user and book from the repositories
        User user = userRepository.findById(wishlistDto.getUserId()).orElse(null);
        Book book = bookRepository.findById(wishlistDto.getBookId()).orElse(null);

        if (user == null || book == null) {
            return ResponseEntity.badRequest().body("User or book not found.");
        }

        // Add the book to the user's wishlist
        user.addToWishlist(book);
        userRepository.save(user);

        return ResponseEntity.ok("Book added to wishlist successfully.");
    }

    @DeleteMapping("/wishlist/remove")
    public ResponseEntity<String> removeFromWishlist(@RequestBody WishlistRemoveDTO wishlistRemoveDTO) {
        // Retrieve the user and book from the repositories
        User user = userRepository.findById(wishlistRemoveDTO.getUserId()).orElse(null);
        Book book = bookRepository.findById(wishlistRemoveDTO.getBookId()).orElse(null);

        if (user == null || book == null) {
            return ResponseEntity.badRequest().body("User or book not found.");
        }

        // Remove the book from the user's wishlist
        user.removeFromWishlist(book);
        userRepository.save(user);

        return ResponseEntity.ok("Book removed from wishlist successfully.");
    }
}
