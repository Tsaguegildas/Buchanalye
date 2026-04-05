package com.pm.backend_buchanalyse.service;

import com.pm.backend_buchanalyse.models.User;
import com.pm.backend_buchanalyse.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){

        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        this.userRepository.save(user);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
