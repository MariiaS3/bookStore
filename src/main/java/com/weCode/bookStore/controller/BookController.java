package com.weCode.bookStore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.service.BookService;


@RestController
@RequestMapping("api/v1/books")
public class BookController { // this controller !!!!!!!!!!!!!!!!!!!!!!

    @Autowired
    private BookService bookService;


    @GetMapping //("api/v1/books") (endpoint)
    public ResponseEntity<List<BookDto>> getBooks(){
        // BookDto book = BookDto.builder().title("My first book title").build();
        // BookDto bookSecond = BookDto.builder().title("Second book title").build(); 
        // List<BookDto>  books = new ArrayList<>();
        // books.add(book);
        // books.add(bookSecond);

        List<BookDto> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }
}
