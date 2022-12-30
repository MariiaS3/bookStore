package com.weCode.bookStore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.weCode.bookStore.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    // List<Book> findBookByTitleAndDescription(String title, String description);
    List<Book> findBookByTitle(String title);
    List<Book> findBookByTitleIgnoreCase(String title);
}
