package com.example.todo.service;

import com.example.todo.entity.UsersEntity;
import com.example.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean createUser(UsersEntity users) {
        try {
            users.setName(users.getName());
            users.setUserName(users.getUserName());
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
