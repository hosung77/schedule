package com.example.schedulee.dto;

import com.example.schedulee.entitty.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ScheduleResponseDto {
    private Long scheduleId;
    private String todo;
    private Long writerId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime scheduleDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.todo = schedule.getTodo();
        this.writerId = schedule.getWriterId();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
        this.scheduleDate = schedule.getScheduleDate();

    }

}
