package com.example.rest_api.service;

import com.example.rest_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rest_api.model.Book;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById( Long id ){
        return bookRepository.findById(id).orElse(null);
    }

    public Book createBook( Book book ){
        System.out.println("The output in createBook is "+ book.getAuthors());
        return bookRepository.save(book);
    }

    public Book updateBook( Long id, Book book){
        Book origBook = bookRepository.findById(id).orElse(null);

        if( origBook != null ){
            origBook.setAuthors(book.getAuthors());
            origBook.setTitle(book.getTitle());
            return bookRepository.save(origBook);
        }

        return null;
    }

    public void deleteBook( Long id ){
        bookRepository.deleteById(id);
    }




}
