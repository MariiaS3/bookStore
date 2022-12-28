package com.weCode.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "Book Api", tags = "Book Api", produces = "aplication/json") //tell about ......
@RestController
@RequestMapping("api/v1/books")
public class BookController { // this controller !!!!!!!!!!!!!!!!!!!!!!

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "get list of books", response =  BookDto[].class, produces = "aplication/json")  //about this endpoint
    @ApiResponses(value = {
        @ApiResponse(code = 200 , message = "Succesfully retrieved list of book"),
        @ApiResponse(code = 403 , message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "not found resource")

    }) //  posible response expected from this endpoint
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


    @ApiOperation(value = "get list of books by title", response =  BookDto[].class, produces = "aplication/json")  //about this endpoint
    @ApiResponses(value = {
        @ApiResponse(code = 200 , message = "Succesfully retrieved list of book by title"),
        @ApiResponse(code = 403 , message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "not found resource")

    }) 
    @GetMapping("/{title}")
    public ResponseEntity<List<BookDto>> getBooksByTitle(@PathVariable("title") String  title){
        List<BookDto> books = bookService.getBooksByTitle(title);
        return ResponseEntity.ok(books);
    }



}
