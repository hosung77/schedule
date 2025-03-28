package com.example.schedulee.controller;


import com.example.schedulee.dto.WriterRegisterRequestDto;
import com.example.schedulee.dto.WriterResponseDto;
import com.example.schedulee.service.WriterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/writer")
@RequiredArgsConstructor
@Slf4j
public class WriterController {

    private final WriterService writerService;


    @PostMapping
    // 사용자 등록
    public ResponseEntity<WriterResponseDto> register(
            @Valid @RequestBody WriterRegisterRequestDto dto
    ){
        WriterResponseDto registeredWriter = writerService.register(dto);
        return new ResponseEntity<>(registeredWriter, HttpStatus.CREATED);
    }

}
