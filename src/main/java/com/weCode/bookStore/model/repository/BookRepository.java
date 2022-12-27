package com.weCode.bookStore.model.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.weCode.bookStore.model.Book;

public interface BookRepository extends CrudRepository<Book, UUID> {
    // List<Book> findBookByTitleAndDescription(String title, String description);
    List<Book> findBookByTitle(String title);
    List<Book> findBookByTitleIgnoreCase(String title);
}
