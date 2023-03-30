package com.losung.contactApplication.service;

import com.losung.contactApplication.entity.Users;
import com.losung.contactApplication.repository.UserRepository;
import com.losung.contactApplication.security.UsersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsersDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser = userRepository.findByUserName(username);
        if(!optionalUser.isPresent())
            throw new UsernameNotFoundException("Username not found");
        return new UsersDetails(optionalUser.get());
    }
}
