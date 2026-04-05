package com.pm.backend_buchanalyse.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String email;
    private  int phone;
    public Timestamp createdAt;

    public User(int id, String email, int phone, Timestamp createdAt) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
