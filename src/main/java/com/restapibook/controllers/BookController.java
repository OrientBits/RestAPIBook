package com.restapibook.controllers;

import com.restapibook.bookServices.BookService;
import com.restapibook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // get all books handler
    @GetMapping("/books")
    public List<Book> getBooks(){
        return this.bookService.getAllBooks();
    }

    // get a books handler
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    //add books handler
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return this.bookService.addBook(book);
    }

    // delete book handler
    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable("id") int id){
        return this.bookService.deleteBook(id);
    }




}
