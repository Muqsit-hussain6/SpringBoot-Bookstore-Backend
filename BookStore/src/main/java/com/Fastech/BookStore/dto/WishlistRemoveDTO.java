package com.Fastech.BookStore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WishlistRemoveDTO {
    private Long userId;
    private Long bookId;

    public WishlistRemoveDTO() {
    }

    public WishlistRemoveDTO(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
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
}
