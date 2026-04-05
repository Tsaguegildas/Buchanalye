package com.pm.backend_buchanalyse.repository;

import com.pm.backend_buchanalyse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
