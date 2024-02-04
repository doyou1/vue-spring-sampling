package com.example.jpah2sampling.controller;

import com.example.jpah2sampling.dto.DeleteUserRequestDto;
import com.example.jpah2sampling.dto.PutUserRequestDto;
import com.example.jpah2sampling.dto.SaveUserRequestDto;
import com.example.jpah2sampling.entity.User;
import com.example.jpah2sampling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User saveUser(
            @RequestBody SaveUserRequestDto saveUserRequestDto
    ) {
        return userService.saveUser(saveUserRequestDto);
    }

    @PutMapping
    public User putUser(
            @RequestBody PutUserRequestDto putUserRequestDto
    ) {
        return userService.putUser(putUserRequestDto);
    }

    @DeleteMapping
    public Boolean deleteUser(
            @RequestBody DeleteUserRequestDto deleteUserRequestDto
    ) {
        return userService.deleteUser(deleteUserRequestDto);
    }

    @GetMapping("/test")
    public String test() {
        userService.readDb();
        return "test";
    }
}
