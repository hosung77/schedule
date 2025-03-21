package com.example.schedulee.controller;

import com.example.schedulee.dto.ScheduleRequestDto;
import com.example.schedulee.dto.ScheduleResponseDto;
import com.example.schedulee.entitty.Schedule;
import com.example.schedulee.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 상품 등록 메서드
    @PostMapping("")
    public ResponseEntity<ScheduleResponseDto> postingSchedule(
            @RequestBody ScheduleRequestDto dto
            ){
        Schedule postedSchedule = scheduleService.postSchedule(dto);
        ScheduleResponseDto responseDto = new ScheduleResponseDto("상품 등록이 완료되었습니다.", postedSchedule);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto); // 상태 코드를 201로 설정
    }
}
