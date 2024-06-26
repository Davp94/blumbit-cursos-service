package com.blumbit.cursosonlineservice.controller;

import com.blumbit.cursosonlineservice.dto.request.LoginRequestDto;
import com.blumbit.cursosonlineservice.util.config.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);
        String token = this.jwtUtil.create(loginRequestDto.getUsername());
        Map<String, String> obj = new HashMap<>();
        obj.put("token", token);
        return ResponseEntity.ok().body(obj);
    }
}
