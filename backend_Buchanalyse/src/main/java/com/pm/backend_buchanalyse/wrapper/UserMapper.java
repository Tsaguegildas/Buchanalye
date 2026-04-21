package com.pm.backend_buchanalyse.wrapper;

import com.pm.backend_buchanalyse.dto.UserResponse;
import com.pm.backend_buchanalyse.models.User;

public class UserMapper {

    public static UserResponse toResponse(User userdb) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(userdb.getId());
        userResponse.setUserRole(userdb.getUserRole());
        userResponse.setEmail(userdb.getEmail());
        userResponse.setPassword(userdb.getPassword());
        userResponse.setFirstName(userdb.getFirstName());
        userResponse.setLastName(userdb.getLastName());
        userResponse.setCreatedAt(userdb.getCreatedAt());
        userResponse.setUpdatedAt(userdb.getUpdatedAt());

        return userResponse;
    }
}