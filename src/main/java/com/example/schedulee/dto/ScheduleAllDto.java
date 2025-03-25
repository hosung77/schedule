package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleAllDto {
    private Long scheduleId;

    private String todo;

    private String writerId;

    private String writerName;

    private LocalDateTime scheduleDate;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
