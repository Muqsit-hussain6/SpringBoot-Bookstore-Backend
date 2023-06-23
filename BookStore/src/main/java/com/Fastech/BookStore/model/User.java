package com.Fastech.BookStore.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wishlist wishlist;

    // Constructors, getters, and setters

    public User() {
        wishlist = new Wishlist(this); // Initialize the wishlist with a reference to the user
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        wishlist = new Wishlist(this); // Initialize the wishlist with a reference to the user
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public void addToWishlist(Book book) {
        wishlist.addBook(book);
    }

    public void removeFromWishlist(Book book) {
    }
}
