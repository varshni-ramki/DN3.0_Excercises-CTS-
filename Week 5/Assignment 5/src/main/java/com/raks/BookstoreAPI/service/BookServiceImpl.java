package com.raks.BookstoreAPI.service;

import com.raks.BookstoreAPI.exception.BookNotFoundException;
import com.raks.BookstoreAPI.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    // In-memory list to simulate a database
    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookById(Long id) {
        return books.stream()
                    .filter(book -> book.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                return book;
            }
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }

    @Override
    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public List<Book> searchBooks(String title, String author) {
        List<Book> filteredBooks = new ArrayList<>();
        
        for (Book book : books) {
            boolean matches = true;
            if (title != null && !book.getTitle().equalsIgnoreCase(title)) {
                matches = false;
            }
            if (author != null && !book.getAuthor().equalsIgnoreCase(author)) {
                matches = false;
            }
            if (matches) {
                filteredBooks.add(book);
            }
        }
        
        return filteredBooks;
    }
}
