package com.Saud.springboothibernatelogin.service.impl;

import com.Saud.springboothibernatelogin.dao.UserDao;
import com.Saud.springboothibernatelogin.dto.ApiResponse;
import com.Saud.springboothibernatelogin.dto.LoginDto;
import com.Saud.springboothibernatelogin.dto.SignUpDto;
import com.Saud.springboothibernatelogin.model.User;
import com.Saud.springboothibernatelogin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ApiResponse signUp(SignUpDto signUpDto) {
        validateSignUp(signUpDto);
        User user = new User();
        BeanUtils.copyProperties(signUpDto, user);
        userDao.save(user);
        return new ApiResponse(200, "success", user);
    }

    @Override
    public ApiResponse login(LoginDto loginDto) {
        User user = userDao.findByUsername(loginDto.getUsername());
        if (user == null) {
            throw new RuntimeException(" User already exists. ");
        }
        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new RuntimeException(" Password mismatch. ");
        }
        return new ApiResponse(200, "Login success", null);

    }

    public void validateSignUp(SignUpDto signUpDto) {
        if (signUpDto.getUsername().length() < 6 || signUpDto.getUsername().length() > 32) {
            throw new RuntimeException("Username length must be between 6 & 32 characters. ");

        }
        User user = userDao.findByUsername(signUpDto.getUsername());
        if(user != null){
            throw new RuntimeException(" User already exists. ");
        }

    }
}
