package com.devariel.cadastro_de_produto.controller;

import com.devariel.cadastro_de_produto.model.User;
import com.devariel.cadastro_de_produto.security.JwtUtil;
import com.devariel.cadastro_de_produto.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request){
        User user = userService.UserSave(request.get("username"), "password");
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request){
        Optional<User> user = userService.findByUsername(request.get("username"));
        if(user.isPresent() && user.get().getPassword().equals(request.get("password"))){
            String token = JwtUtil.generatyToken(user.get().getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body("invalid credentials");
    }
}
