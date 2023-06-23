package com.Fastech.BookStore.controller;
import com.Fastech.BookStore.dto.OrderDto;
import com.Fastech.BookStore.model.Book;
import com.Fastech.BookStore.model.Order;
import com.Fastech.BookStore.model.User;
import com.Fastech.BookStore.repository.BookRepository;
import com.Fastech.BookStore.repository.OrderRepository;
import com.Fastech.BookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class OrderController {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(UserRepository userRepository, BookRepository bookRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders/add")
    public ResponseEntity<String> addOrder(@RequestBody OrderDto orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId()).orElse(null);
        Book book = bookRepository.findById(orderDTO.getBookId()).orElse(null);

        if (user == null || book == null) {
            return ResponseEntity.badRequest().body("User or book not found.");
        }

        int quantity = orderDTO.getQuantity();
        double totalPrice = book.getPrice() * quantity;

        // Create the order
        Order order = new Order(LocalDate.now(), totalPrice, user, book);
        orderRepository.save(order);

        return ResponseEntity.ok("Order placed successfully.");
    }
    @DeleteMapping("/orders/{orderId}/books/{bookId}")
    public ResponseEntity<String> removeBookFromOrder(@PathVariable Long orderId, @PathVariable Long bookId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (order == null || book == null) {
            return ResponseEntity.badRequest().body("Order or book not found.");
        }

        // Set the book and quantity to null or update them according to your application's logic
        order.setBook(null);
        order.setQuantity(0);
        orderRepository.save(order);

        return ResponseEntity.ok("Book removed from the order successfully.");
    }



}
