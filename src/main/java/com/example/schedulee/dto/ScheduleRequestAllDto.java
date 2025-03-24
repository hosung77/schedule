package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleRequestAllDto {
    private String writer;
    private LocalDate modifiedAt;
}
