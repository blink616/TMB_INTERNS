package com.shehriyar.LoginSystem.service;

import com.shehriyar.LoginSystem.model.CustomUserDetails;
import com.shehriyar.LoginSystem.model.User;
import com.shehriyar.LoginSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with the username: " + username));

        System.out.println(user.getUsername());

        return new CustomUserDetails(user);
    }

}
