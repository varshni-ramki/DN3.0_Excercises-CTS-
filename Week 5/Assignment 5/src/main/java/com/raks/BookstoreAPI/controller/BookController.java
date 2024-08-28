package com.raks.BookstoreAPI.controller;

import com.raks.BookstoreAPI.dto.BookDTO;
import com.raks.BookstoreAPI.mapper.BookMapper;
import com.raks.BookstoreAPI.model.Book;
import com.raks.BookstoreAPI.service.BookService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/books")
@Tag(name = "Book Controller", description = "Manage books in the bookstore")
public class BookController {

    @Autowired
    private BookService bookService;

        
    public EntityModel<BookDTO> getBookById1(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
        
        EntityModel<BookDTO> resource = EntityModel.of(bookDTO);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById1(id)).withSelfRel();
        resource.add(selfLink);
        
        return resource;
    }


    @GetMapping(produces = { "application/json", "application/xml" })
    @Operation(summary = "Get all books", description = "Retrieve a list of all books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json", "application/xml" })
       public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book updatedBook) {
        Book book = bookService.updateBook(id, updatedBook);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String title,
                                                  @RequestParam(required = false) String author) {
        List<Book> filteredBooks = bookService.searchBooks(title, author);
        return ResponseEntity.ok(filteredBooks);
    }
    }


