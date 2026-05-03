package com.pm.backend_buchanalyse.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Data
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String beruf;
    @Column(nullable=false)
    private String adress;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private  LocalDateTime updateAt;
}
