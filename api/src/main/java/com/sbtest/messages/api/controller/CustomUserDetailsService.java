package com.sbtest.messages.api.controller;

import com.sbtest.messages.api.bo.UserBO;
import com.sbtest.messages.api.exception.DAOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserBO userService;

    @Autowired
    public CustomUserDetailsService(UserBO userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            return this.userService.findByEmail(email);
        } catch (DAOException e) {
            throw new UsernameNotFoundException("Seu usuário não foi encontrado.");
        }
    }
}