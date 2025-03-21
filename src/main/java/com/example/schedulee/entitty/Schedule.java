package com.example.schedulee.entitty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private Long scheduleId;
    private String todo;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
