package com.example.rest_api.controller;

import com.example.rest_api.model.Book;
import com.example.rest_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
//        return "Hello World";
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        if( book != null ){
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Book createBook( @RequestBody Book book ){
        System.out.println("The function call for createBook is received with the details are: "
                + book.getTitle() +" " + book.getAuthors());
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook( @PathVariable Long id, @RequestBody Book bookDetails ){

        Book book = bookService.updateBook(id, bookDetails);

        if( book != null ){
            return ResponseEntity.ok(bookDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook( @PathVariable Long id ){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
