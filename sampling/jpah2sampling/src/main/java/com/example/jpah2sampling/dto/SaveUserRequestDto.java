package com.example.jpah2sampling.dto;

import com.example.jpah2sampling.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserRequestDto {

    private String email;
    private String password;

    public User toEntity() {
        return new User(
                null,
                this.email,
                this.password,
                LocalDate.now()
        );
    }
}
