package com.example.schedulee.controller;

import com.example.schedulee.dto.SearchedScheduleDto;
import com.example.schedulee.dto.WriterRegisterRequestDto;
import com.example.schedulee.dto.WriterResponseDto;
import com.example.schedulee.service.WriterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/writer")
@RequiredArgsConstructor
@Slf4j
public class WriterController {

    private final WriterService writerService;


    @PostMapping
    public ResponseEntity<WriterResponseDto> register(
            @RequestBody WriterRegisterRequestDto dto
    ){
        WriterResponseDto registeredWriter = writerService.register(dto);
        return new ResponseEntity<>(registeredWriter, HttpStatus.CREATED);
    }

}
