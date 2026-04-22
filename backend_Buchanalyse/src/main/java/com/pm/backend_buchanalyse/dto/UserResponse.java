package com.pm.backend_buchanalyse.dto;

import com.pm.backend_buchanalyse.enums.UserRole;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserResponse {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole userRole= UserRole.USER;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Data
    public static class AdressResponse {
        private int Id;
        private String land;
        private String stadt;
        private int postleizahl;
        private String hausnummer;
        private LocalDateTime createdAt;
        private LocalDateTime updateAt;

    }
}
