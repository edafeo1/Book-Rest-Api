package com.fegohuncho.bookrestapi.controller;

import com.fegohuncho.bookrestapi.model.Book;
import com.fegohuncho.bookrestapi.services.ImplementationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins="http://localhost:3000")
public class BookController implements GenericController<Book> {


    @Autowired
    private ImplementationService<Book> bookService;

    @Override
    public Page<Book> findAllByText(Pageable pageable, String Text) {
        return bookService.findAllByText(pageable, Text);
    }

    @Override
    public Page<Book> findAll(int pageNo) {
        return bookService.findByPage(pageNo);
    }

    @Override
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookService.findById(id);
    }

    @Override
    public void deleteById(long id) {
        bookService.deleteById(id);
    }

    @Override
    public void updateById(long id, Book book) {
        bookService.Update(id, book);
    }

    @Override
    public void Save(Book book) {
        bookService.Save(book);
    }
}
