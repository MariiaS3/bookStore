package com.weCode.bookStore.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.service.BookService;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    
    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    void shouldRetornBookDtoListWhenGetBooksColled(){
        List<BookDto> bookDtos = new ArrayList<>();
        bookDtos.add(getBookDto());
        when(bookService.getBooks()).thenReturn(bookDtos);
        ResponseEntity<List<BookDto>> books = bookController.getBooks();
        assertThat(books.getBody()).isNotNull();
        assertThat(books.getBody().size()).isEqualTo(1);
    }

    private BookDto getBookDto(){
        return BookDto.builder().title("test title").description("test description").id(10).releaseYear(2020).build();

    }
}
