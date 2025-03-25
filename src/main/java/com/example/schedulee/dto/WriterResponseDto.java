package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class WriterResponseDto {
    private Long writerId;
    private String writerEmail;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
