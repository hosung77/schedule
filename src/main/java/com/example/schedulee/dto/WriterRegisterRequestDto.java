package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Setter
public class WriterRegisterRequestDto {
    private String email;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
