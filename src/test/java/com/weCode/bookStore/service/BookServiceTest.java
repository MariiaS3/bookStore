package com.weCode.bookStore.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.weCode.bookStore.dto.BookDto;
import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.model.repository.BookRepository;
import com.weCode.bookStore.service.BookService;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void shouldRetornListOfBookDtoWhenGetBooksColled(){
        List<Book> books = new ArrayList<>();
        Book book= getBook();
        books.add(getBook());
        BookDto bookDto = getBookDto();
        when(bookRepository.findAll()).thenReturn(books);
        when(modelMapper.map(book, BookDto.class)).thenReturn(bookDto);
        List<BookDto> bookDtos =  bookService.getBooks();
        assertThat(1).isEqualTo(bookDtos.size());
        assertThat(bookDtos.get(0)).isNotNull()
        .hasFieldOrPropertyWithValue("title", "test title")
        .hasFieldOrPropertyWithValue("description", "test description")
        .hasFieldOrPropertyWithValue("releaseYear",2020);
    }


    private Book getBook(){
        return Book.builder().title("test title").description("test description").id(10).releaseYear(2020).build();
    }


    private BookDto getBookDto(){
        return BookDto.builder().title("test title").description("test description").id(10).releaseYear(2020).build();

    }
}
