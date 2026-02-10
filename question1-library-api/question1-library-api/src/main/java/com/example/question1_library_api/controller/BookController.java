package com.example.question1_library_api.controller;

import com.example.question1_library_api.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "Clean Code", "Robert Martin"));
        books.add(new Book(2, "Effective Java", "Joshua Bloch"));
    }

    // GET /api/books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // GET /api/books/{id}
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
