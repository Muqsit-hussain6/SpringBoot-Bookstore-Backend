package com.Fastech.BookStore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long bookId;

    private String title;

    private String author;

    private String ISBN;

    private String url;

    private double price;
}
