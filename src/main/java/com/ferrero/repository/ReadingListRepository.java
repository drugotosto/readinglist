package com.ferrero.repository;

import com.ferrero.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by drugo on 16/06/2017.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}