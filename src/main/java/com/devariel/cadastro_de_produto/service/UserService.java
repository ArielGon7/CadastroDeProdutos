package com.devariel.cadastro_de_produto.service;

import com.devariel.cadastro_de_produto.model.User;
import com.devariel.cadastro_de_produto.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    public final UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    
    public User UserSave(String username, String password){
        String passwordCryptography = passwordEncoder.encode(password);
        User user = new User(username, passwordCryptography);
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
