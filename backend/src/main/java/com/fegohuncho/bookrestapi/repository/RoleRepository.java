package com.fegohuncho.bookrestapi.repository;

import com.fegohuncho.bookrestapi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
