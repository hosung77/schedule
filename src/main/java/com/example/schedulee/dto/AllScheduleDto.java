package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AllScheduleDto {
    private Long scheduleId;

    private String todo;

    private String writerId;

    private String writerName;

    private LocalDateTime scheduleDate;

}
