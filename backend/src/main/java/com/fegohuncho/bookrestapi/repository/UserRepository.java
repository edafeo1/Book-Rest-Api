package com.fegohuncho.bookrestapi.repository;


import com.fegohuncho.bookrestapi.model.User;
import com.fegohuncho.bookrestapi.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("FROM User u WHERE u.firstName LIKE %:searchText% OR u.lastName LIKE %:searchText% OR u.email LIKE %:searchText% ORDER BY u.id ASC")
    Page<User> findAllUsers(Pageable pageable, @Param("searchText") String searchText);
}
