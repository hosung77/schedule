package com.example.schedulee.controller;

import com.example.schedulee.dto.ScheduleAllDto;
import com.example.schedulee.dto.ScheduleRequestAllDto;
import com.example.schedulee.dto.ScheduleRequestDto;
import com.example.schedulee.dto.ScheduleResponseDto;
import com.example.schedulee.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 상품 등록 메서드
    @PostMapping // 상품 등록 컨트롤러
    public ResponseEntity<ScheduleResponseDto> postingSchedule(
            @RequestBody ScheduleRequestDto dto
            ){
        ScheduleResponseDto postedSchedule = scheduleService.postSchedule(dto);

        return new ResponseEntity<>(postedSchedule, HttpStatus.CREATED);
    }

    // 수정일과 작성자가 일치하는 스케쥴 응답해주는 메서드
    @GetMapping ("/all")
    ResponseEntity<List<ScheduleAllDto>> getAllSchedule(@RequestBody
                                                                     ScheduleRequestAllDto sc){
        List <ScheduleAllDto> getAllInfo = scheduleService.searchAll(sc);

        return new ResponseEntity<>(getAllInfo,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long id){

        ScheduleResponseDto sc = scheduleService.searchSchedule(id);

        return new ResponseEntity<>(sc, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    ResponseEntity<ScheduleResponseDto> editInfo(@PathVariable Long id)
}
