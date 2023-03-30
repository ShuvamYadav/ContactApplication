package com.losung.contactApplication.controller;

import com.losung.contactApplication.entity.Users;
import com.losung.contactApplication.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/signup")
    public Users signup(@Valid @RequestBody Users user) {
        return usersService.signup(user);
    }

}
