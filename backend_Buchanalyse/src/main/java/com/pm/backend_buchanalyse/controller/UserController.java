package com.pm.backend_buchanalyse.controller;

import com.pm.backend_buchanalyse.models.User;
import com.pm.backend_buchanalyse.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
        public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public  void addUser(@RequestBody User user){
        User user1= new User();
        this.userService.addUser(user);
}
}
