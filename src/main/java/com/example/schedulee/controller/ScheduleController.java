package com.example.schedulee.controller;

import com.example.schedulee.dto.*;
import com.example.schedulee.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 상품 등록
    @PostMapping // 일정 등록 컨트롤러
    public ResponseEntity<ScheduleResponseDto> postingSchedule(
            @Valid @RequestBody ScheduleRequestDto dto
            ){
        ScheduleResponseDto postedSchedule = scheduleService.postSchedule(dto);

        return new ResponseEntity<>(postedSchedule, HttpStatus.CREATED);
    }

    // 사용자 아이디와 일치하는 컬럼을 모두 반환
    @GetMapping("/all")
    public ResponseEntity<Paging<ScheduleAllDto>> getAllSchedule(
            @RequestParam String writerName,
            @RequestParam LocalDateTime modifiedAt,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        ScheduleRequestAllDto requestDto = new ScheduleRequestAllDto(writerName, modifiedAt);
        Paging<ScheduleAllDto> result = scheduleService.searchAllWithPaging(requestDto, page, size);

        return ResponseEntity.ok(result);
    }

    // 일정의 아이디와 일치하는 컬럼을 반환
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
    public ResponseEntity<SearchedScheduleDto> editInfo(@Valid @RequestBody ScheduleEditRequestDto dto,
    @PathVariable Long id){

        SearchedScheduleDto editedSchedule = scheduleService.editInfo(dto,id);
        return new ResponseEntity<>(editedSchedule, HttpStatus.OK);
    }

    // 스케줄 삭제
    @DeleteMapping()
    public ResponseEntity<String> deleteSchedule(@Valid @RequestBody ScheduleDeleteRequestDto dto){

        scheduleService.deleteSchedule(dto);

        return ResponseEntity.ok("선택한 스케줄이 삭제되었습니다.");
    }
}
