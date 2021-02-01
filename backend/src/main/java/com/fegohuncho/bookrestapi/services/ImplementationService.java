package com.fegohuncho.bookrestapi.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ImplementationService<T> {
    String Save(T t);

    String Update(long id, T t);

    String deleteById(long id);

    // Fix bug Here
    Optional<T> findById(long id);

    List<T> findAll();

    Page<T> findByPage(int pageNo);

    Page<T > findAllByText(Pageable pageable, String text);


}