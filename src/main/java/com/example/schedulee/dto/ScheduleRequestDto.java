package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequestDto {
    private Long scheduleId;
    private String todo;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
