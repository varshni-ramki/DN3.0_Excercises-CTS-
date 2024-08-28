package com.raks.BookstoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

import lombok.Data;

@Data
public class BookDTO {
    @JsonProperty("book_id")
    private Long id;
    @NotNull(message = "Title is required")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;
    @NotNull(message = "Author is required")
    @Size(min = 1, max = 100, message = "Author must be between 1 and 100 characters")

    private String author;
    @Min(value = 0, message = "Price must be positive")

    private Double price;
    @NotNull(message = "ISBN is required")
    @JsonProperty("isbn_code")
    private String isbn;
}
