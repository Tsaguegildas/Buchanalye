package com.pm.backend_buchanalyse.dto;

import com.pm.backend_buchanalyse.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

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
}
