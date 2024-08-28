package com.example.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.dto.BookDTO;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    // Create a new book
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        bookService.saveBook(book);
        BookDTO createdBookDTO = bookMapper.toBookDTO(book);
        return new ResponseEntity<>(createdBookDTO, HttpStatus.CREATED);
    }

    // Read all books
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = BookService.findAllBooks();
        List<BookDTO> bookDTOs = books.stream()
                                      .map(bookMapper::toBookDTO)
                                      .toList();
        return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
    }

    // Read a book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        if (book != null) {
            BookDTO bookDTO = bookMapper.toBookDTO(book);
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        book.setId(id); // Ensure the book has the correct ID
        Book updatedBook = bookService.updateBook(book);
        BookDTO updatedBookDTO = bookMapper.toBookDTO(updatedBook);
        return new ResponseEntity<>(updatedBookDTO, HttpStatus.OK);
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
