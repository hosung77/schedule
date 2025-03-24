package com.example.schedulee.entitty;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Schedule {
    private Long scheduleId;

    private String todo;

    private String writer;

    private String password;

    private LocalDateTime scheduleDate;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
