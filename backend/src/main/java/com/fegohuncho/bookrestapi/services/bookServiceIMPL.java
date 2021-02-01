package com.fegohuncho.bookrestapi.services;

import com.fegohuncho.bookrestapi.model.Book;
import com.fegohuncho.bookrestapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bookServiceIMPL implements  ImplementationService<Book> {

    @Autowired
    private final BookRepository bookRepository;

    public bookServiceIMPL(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String Save(Book book) {
        JSONObject jsonObject = new JSONObject();
        try {
            bookRepository.save(book);
            jsonObject.put("message", "Book Added successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public String Update(long id, Book book){
        JSONObject jsonObject = new JSONObject();
        Optional<Book> newBook = bookRepository.findById(id);
        if (newBook.isEmpty()){
            try {
                jsonObject.put("message", "Book does not Exist");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject.toString();
        }
        else {

            try {
                bookRepository.save(book);
                jsonObject.put("message", "Book Updated successfully");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject.toString();
        }
    }


    @Override
    public String deleteById(long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            bookRepository.deleteById(id);
            jsonObject.put("message", "Book deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Page<Book> findByPage(int pageNo) {
        int size = 1;
        Pageable p = PageRequest.of(pageNo, size);
        return bookRepository.findAll(p);
    }

    @Override
    public Page<Book> findAllByText(Pageable pageable, String text) {
        return bookRepository.findAllBooks(pageable, text);
    }
}
