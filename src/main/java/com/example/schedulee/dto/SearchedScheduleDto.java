package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class SearchedScheduleDto {
    private Long scheduleId;
    private Long writerId;
    private String writerName;
    private String writerEmail;
    private String todo;
    private LocalDateTime scheduleDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
