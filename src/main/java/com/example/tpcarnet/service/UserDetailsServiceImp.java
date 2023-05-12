package com.example.tpcarnet.service;

import com.example.tpcarnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        UserDetails userDetails= userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email" + email + "not found"));

        return userDetails;
    }
}
