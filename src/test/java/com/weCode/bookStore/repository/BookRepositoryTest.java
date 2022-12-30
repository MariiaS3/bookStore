package com.weCode.bookStore.repository;

import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.repository.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
    
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void shouldAbleToFetchAllBookInDB(){
        Iterable<Book> all = bookRepository.findAll();
        Long totalBookCount =  StreamSupport.stream(all.spliterator(), false).count();
        Assertions.assertEquals(totalBookCount, 18);
    }

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void souldReturnOneBookWhenTitleIsTestTitle(){
        List<Book> books =  bookRepository.findBookByTitle("test title");
        Assertions.assertEquals(books.size(), 1);
    }

    @Test
    @Sql(scripts = {"classpath:InsertInitialBookRecordForTest.sql"})
    void souldReturnOneBookWhenTitleIsTestTitleIgnoreCase(){
        List<Book> books =  bookRepository.findBookByTitleIgnoreCase("Test Title");
        Assertions.assertEquals(books.size(), 1);
    }
}
