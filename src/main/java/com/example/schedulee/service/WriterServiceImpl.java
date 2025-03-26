package com.example.schedulee.service;


import com.example.schedulee.dto.WriterRegisterRequestDto;
import com.example.schedulee.dto.WriterResponseDto;
import com.example.schedulee.entitty.Writer;
import com.example.schedulee.exception.CustomException;
import com.example.schedulee.exception.ErrorCode;
import com.example.schedulee.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    @Override
    public WriterResponseDto register(WriterRegisterRequestDto dto) {
        if (dto.getCreatedAt() == null && dto.getModifiedAt() == null) {
            dto.setCreatedAt(LocalDateTime.now());
            dto.setModifiedAt(LocalDateTime.now());
        }

        boolean isValidName = writerRepository.findByName(dto.getName());

        if(isValidName != false) {
            throw new CustomException(ErrorCode.WRITER_ALREADY_EXIST);
        }

        Writer writer = new Writer(null,dto.getEmail(),dto.getName(),dto.getCreatedAt(),dto.getModifiedAt());

        WriterResponseDto registeredWriter = writerRepository.saveWriter(writer);
        return registeredWriter;
    }

}
