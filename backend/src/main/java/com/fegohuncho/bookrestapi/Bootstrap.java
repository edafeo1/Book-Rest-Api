package com.fegohuncho.bookrestapi;

import com.fegohuncho.bookrestapi.model.Role;
import com.fegohuncho.bookrestapi.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class Bootstrap implements CommandLineRunner {
    private final RoleRepository roleRepository;

    public Bootstrap(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        /*
        roleRepository.deleteAll();
        Role admin = new Role();
        admin.setName("ROLE_ADMIN");
        Role user = new Role();
        user.setName("ROLE_USER");

        roleRepository.saveAll(List.of(admin, user));
        
         */
    }
}
