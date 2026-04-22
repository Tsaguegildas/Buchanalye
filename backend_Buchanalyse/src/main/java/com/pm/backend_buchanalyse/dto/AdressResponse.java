package com.pm.backend_buchanalyse.dto;

import lombok.Data;

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