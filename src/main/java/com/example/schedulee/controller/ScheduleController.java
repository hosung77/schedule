package com.example.schedulee.controller;

import com.example.schedulee.dto.*;
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

    // 상품 등록
    @PostMapping // 상품 등록 컨트롤러
    public ResponseEntity<ScheduleResponseDto> postingSchedule(
            @RequestBody ScheduleRequestDto dto
            ){
        ScheduleResponseDto postedSchedule = scheduleService.postSchedule(dto);

        return new ResponseEntity<>(postedSchedule, HttpStatus.CREATED);
    }

    // 수정일과 작성자가 일치하는 스케줄 응답
    @GetMapping ("/all")
    public ResponseEntity<List<ScheduleAllDto>> getAllSchedule(@RequestBody
                                                                     ScheduleRequestAllDto sc){
        List <ScheduleAllDto> getAllInfo = scheduleService.searchAll(sc);

        return new ResponseEntity<>(getAllInfo,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SearchedScheduleDto>> searchSchedule(
            @PathVariable Long id
    ){
        System.out.println("Received ID: " + id);  // ID 값이 제대로 전달 되는지 확인
        List<SearchedScheduleDto> dto = scheduleService.searchSchedule(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // 스케줄 수정
    @PatchMapping("/{id}")
    public ResponseEntity<SearchedScheduleDto> editInfo(@RequestBody ScheduleEditRequestDto dto,
    @PathVariable Long id){

        SearchedScheduleDto editedSchedule = scheduleService.editInfo(dto,id);
        return new ResponseEntity<>(editedSchedule, HttpStatus.OK);
    }

    // 스케줄 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@RequestBody ScheduleDeleteRequestDto dto){

        scheduleService.deleteSchedule(dto);

        return ResponseEntity.ok("선택한 스케줄이 삭제되었습니다.");
    }
}
