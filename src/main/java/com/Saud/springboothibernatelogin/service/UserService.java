package com.Saud.springboothibernatelogin.service;

import com.Saud.springboothibernatelogin.dto.ApiResponse;
import com.Saud.springboothibernatelogin.dto.LoginDto;
import com.Saud.springboothibernatelogin.dto.SignUpDto;

public interface UserService {

    ApiResponse signUp(SignUpDto signUpDto);

    ApiResponse login(LoginDto loginDto);
}
