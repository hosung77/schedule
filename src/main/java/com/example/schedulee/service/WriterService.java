package com.example.schedulee.service;

import com.example.schedulee.dto.WriterRegisterRequestDto;
import com.example.schedulee.dto.WriterResponseDto;



public interface WriterService {
    WriterResponseDto register(WriterRegisterRequestDto dto);

}
