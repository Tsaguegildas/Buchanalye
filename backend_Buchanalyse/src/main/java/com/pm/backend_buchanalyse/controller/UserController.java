package com.pm.backend_buchanalyse.controller;

import com.pm.backend_buchanalyse.dto.UserRequest;
import com.pm.backend_buchanalyse.dto.UserResponse;
import com.pm.backend_buchanalyse.models.User;
import com.pm.backend_buchanalyse.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public ResponseEntity <List<UserResponse>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable int id){
        return  ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping(consumes= APPLICATION_JSON_VALUE)
    public  ResponseEntity <UserResponse>  addUser(@Valid @RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.addUser(userRequest)) ;

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}",consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> updateUser(@RequestBody User user, @PathVariable int id){
        UserResponse userResponse = userService.updateUser(user,id);
        return ResponseEntity.ok(userResponse);
    }
}

