package com.example.Sale.of.slaves.repositories;

import com.example.Sale.of.slaves.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
