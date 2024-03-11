package com.example.Sale.of.slaves.service;

import com.example.Sale.of.slaves.models.User;
import com.example.Sale.of.slaves.models.enums.Role;
import com.example.Sale.of.slaves.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        String email = user.getEmail();
        if(userRepository.findByEmail(email) != null) return false;
        // Хэширование пароля
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }
}
