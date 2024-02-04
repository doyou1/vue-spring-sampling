package com.example.jpah2sampling.service;

import com.example.jpah2sampling.dto.DeleteUserRequestDto;
import com.example.jpah2sampling.dto.PutUserRequestDto;
import com.example.jpah2sampling.dto.SaveUserRequestDto;
import com.example.jpah2sampling.entity.User;
import com.example.jpah2sampling.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Service
public class UserService implements ApplicationListener<ContextClosedEvent>
{

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init() {
        System.err.println("User Service init");
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.err.println("application close");
    }

    public void readDb()  {
        try {
            File file = ResourceUtils.getFile("classpath:db/demodb.mv.db");
            System.err.println(file.isFile());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

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
