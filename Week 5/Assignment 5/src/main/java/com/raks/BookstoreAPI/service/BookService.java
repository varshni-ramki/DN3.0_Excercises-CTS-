package com.raks.BookstoreAPI.service;

import com.raks.BookstoreAPI.model.Book;

import io.micrometer.core.annotation.Counted;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    @Counted(value = "books.added", description = "Number of books added")
    Book addBook(Book book);
    Book updateBook(Long id, Book updatedBook);
    void deleteBook(Long id);
    List<Book> searchBooks(String title, String author);


}
