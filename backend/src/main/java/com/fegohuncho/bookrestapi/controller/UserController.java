package com.fegohuncho.bookrestapi.controller;


import com.fegohuncho.bookrestapi.model.Role;
import com.fegohuncho.bookrestapi.model.User;
import com.fegohuncho.bookrestapi.repository.RoleRepository;
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
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController implements GenericController<User> {

    @Autowired
    private ImplementationService<User> userService;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<User> findAllByText(Pageable pageable, String Text) {
        return userService.findAllByText(pageable, Text);
    }

    @Override
    public Page<User> findAll(int pageNo) {
        return userService.findByPage(pageNo);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userService.findById(id);
    }

    @Override
    public void deleteById(long id) {
        userService.deleteById(id);
    }

    @Override
    public void updateById(long id, User user) {
        userService.Update(id, user);
    }

    /**
     * User -> Role
     * types of roles are limited
     * ROLE_USER ROLE_STUDENT
     * Have a list of role
     */
    @Override
    public void Save(User user) {
        Role rol = user.getRoles();

        Role dbRole = roleRepository.findByName(rol.getName());
        user.setRoles(dbRole);

        userService.Save(user);
    }
}
