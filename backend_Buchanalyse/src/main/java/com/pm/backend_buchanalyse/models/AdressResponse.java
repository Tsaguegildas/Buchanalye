package com.pm.backend_buchanalyse.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class AdressResponse {
    private int Id;
    private String land;
    private String stadt;
    private int postleizahl;
    private String hausnummer;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
