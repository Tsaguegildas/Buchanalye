package com.pm.backend_buchanalyse.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Entity
@Table(name ="adress")
@Data
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column (nullable = false)
    private String land;
    @Column(nullable = false)
    private String stadt;
    @Column(nullable = false)
    private int postleizahl;
    @Column(nullable = false)
    private String hausnummer;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updateAt;

}

