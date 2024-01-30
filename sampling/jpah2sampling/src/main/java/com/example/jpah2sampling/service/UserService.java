package com.example.jpah2sampling.service;

import com.example.jpah2sampling.dto.DeleteUserRequestDto;
import com.example.jpah2sampling.dto.PutUserRequestDto;
import com.example.jpah2sampling.dto.SaveUserRequestDto;
import com.example.jpah2sampling.entity.User;
import com.example.jpah2sampling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(SaveUserRequestDto saveUserRequestDto) {
        return userRepository.save(saveUserRequestDto.toEntity());
    }

    public User putUser(PutUserRequestDto putUserRequestDto) {
        return userRepository.save(putUserRequestDto.toEntity());
    }

    public Boolean deleteUser(DeleteUserRequestDto deleteUserRequestDto) {
        userRepository.delete(deleteUserRequestDto.toEntity());
        return true;
    }
}
