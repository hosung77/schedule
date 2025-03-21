package com.example.schedulee.dto;

import com.example.schedulee.entitty.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponseDto {

    private String message;
    private Long scheduleId;
    private String todo;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    // 상품 등록 후 반환할 데이터를 위한 생성자 (메시지 추가)
    public ScheduleResponseDto(String message, Schedule schedule) {
        this.message = message;
        this.scheduleId = schedule.getScheduleId();
        this.todo = schedule.getTodo();
        this.writer = schedule.getWriter();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
