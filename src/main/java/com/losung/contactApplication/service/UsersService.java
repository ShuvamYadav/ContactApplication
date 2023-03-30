package com.losung.contactApplication.service;

import com.losung.contactApplication.entity.Users;
import com.losung.contactApplication.exceptions.UserNameTakenException;
import com.losung.contactApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public Users signup(Users user) {
        Optional<Users> optionalUser = userRepository.findByUserName(user.getUserName());
        if(optionalUser.isPresent())
            throw new UserNameTakenException();
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
