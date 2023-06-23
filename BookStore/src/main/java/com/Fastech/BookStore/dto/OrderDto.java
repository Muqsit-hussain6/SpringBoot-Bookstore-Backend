package com.Fastech.BookStore.dto;

public class OrderDto {
    private Long userId;
    private Long bookId;
    private int quantity;
    private double totalPrice;

    // Constructors, getters, and setters

    public OrderDto() {
    }

    public OrderDto(Long userId, Long bookId, int quantity, double totalPrice) {
        this.userId = userId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
