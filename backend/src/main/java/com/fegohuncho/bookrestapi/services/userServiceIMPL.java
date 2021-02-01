package com.fegohuncho.bookrestapi.services;

import com.fegohuncho.bookrestapi.model.User;
import com.fegohuncho.bookrestapi.repository.UserRepository;
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
public class userServiceIMPL implements ImplementationService<User>{

    @Autowired
    private final UserRepository userRepository;

    public userServiceIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public String Save(User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            userRepository.save(user);
            jsonObject.put("message", "User Added successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public String Update(long id, User user){
        JSONObject jsonObject = new JSONObject();
        Optional<User> newUser = userRepository.findById(id);
        if (newUser.isEmpty()){
            try {
                jsonObject.put("message", "User does not Exist");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject.toString();
        }
        else {

            try {
                userRepository.save(user);
                jsonObject.put("message", "User Updated successfully");
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
            userRepository.deleteById(id);
            jsonObject.put("message", "User deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Page<User> findByPage(int pageNo) {
        int size = 1;
        Pageable p = PageRequest.of(pageNo, size);
        return userRepository.findAll(p);
    }

    @Override
    public Page<User> findAllByText(Pageable pageable, String text) {
        return userRepository.findAllUsers(pageable, text);

    }
}
