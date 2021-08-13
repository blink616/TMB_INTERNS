package com.shehriyar.LoginSystem.controller;

import com.shehriyar.LoginSystem.model.LoginRequest;
import com.shehriyar.LoginSystem.service.CustomUserDetailsService;
import com.shehriyar.LoginSystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/welcome")
    public Map<String, String> welcome() {

        Map<String, String> response = new HashMap<>();
        response.put("result", "Welcome Guest");

        return response;
    }

    @PostMapping("/generate_token")
    public Map<String, String> generate_token(@RequestBody LoginRequest loginRequest) throws Exception {

        System.out.println("TESTING");

        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credentials!");
        }

        Map<String, String> response = new HashMap<>();

        try {
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(loginRequest.getUsername());

            String token = this.jwtUtil.generateToken(userDetails);


            response.put("token", token);

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;
    }

}
