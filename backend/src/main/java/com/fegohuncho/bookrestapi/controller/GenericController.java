package com.fegohuncho.bookrestapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public interface GenericController<T> {

    @GetMapping("/search/{text}")
    Page<T> findAllByText(Pageable pageable, @PathVariable("text") String Text);

    @GetMapping("/page/{pageNo}")
    Page<T> findAll(@PathVariable("pageNo") int pageNo);

    @GetMapping
    List<T> findAll();


    @GetMapping(path = "{id}")
    Optional<T> findById(@PathVariable("id") long id);

    @DeleteMapping(path = "{id}")
    void deleteById(@PathVariable("id") long id);


    @PutMapping(path = "{id}")
    void updateById(@PathVariable("id") long id, @RequestBody T t);

    @PostMapping
    void Save(@RequestBody T t);
}
