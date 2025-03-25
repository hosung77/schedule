package com.example.schedulee.service;

import com.example.schedulee.dto.SearchedScheduleDto;
import com.example.schedulee.dto.WriterRegisterRequestDto;
import com.example.schedulee.dto.WriterResponseDto;

import java.util.List;

public interface WriterService {
    WriterResponseDto register(WriterRegisterRequestDto dto);

}
