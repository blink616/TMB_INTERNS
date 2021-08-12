package com.Saud.springboothibernatelogin.controller;

import com.Saud.springboothibernatelogin.dto.ApiResponse;
import com.Saud.springboothibernatelogin.dto.LoginDto;
import com.Saud.springboothibernatelogin.dto.SignUpDto;
import com.Saud.springboothibernatelogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }


}
