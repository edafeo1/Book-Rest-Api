package com.fegohuncho.bookrestapi.repository;

import com.fegohuncho.bookrestapi.model.Book;
import com.fegohuncho.bookrestapi.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    @Query("FROM Book b WHERE b.title LIKE %:searchText% OR b.author LIKE %:searchText% OR b.language LIKE %:searchText% ORDER BY b.id ASC")
    Page<Book> findAllBooks(Pageable pageable, @Param("searchText") String searchText);
}
