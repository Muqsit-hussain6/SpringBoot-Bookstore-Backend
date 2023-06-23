package com.Fastech.BookStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
@JsonProperty
    private String title;
@JsonProperty
private String author;
    @JsonProperty
private String ISBN;
    @JsonProperty
    private String url;
    @JsonProperty
    private double price;

    @ManyToMany(mappedBy = "books")
    private List<Wishlist> wishlists;

    // Constructors, getters, and setters

    public Book() {
    }

    public Book(String title, String author, String ISBN, double price,String url) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        this.url = url;
    }

    // Getters and setters

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Wishlist> getWishlists() {
        return wishlists;
    }

    public void setWishlists(List<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }
}
