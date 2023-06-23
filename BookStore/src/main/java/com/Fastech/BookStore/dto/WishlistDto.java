package com.Fastech.BookStore.dto;

public class WishlistDto {
    private Long userId;
    private Long bookId;

    // Constructors
    public WishlistDto() {
    }

    public WishlistDto(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
