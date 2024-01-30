package com.example.jpah2sampling.dto;

import com.example.jpah2sampling.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserRequestDto {
    private Long userId;

    public User toEntity() {
        return new User(
                this.userId,
                null,
                null,
                null
        );
    }
}
