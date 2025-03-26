package com.example.schedulee.repository;

import com.example.schedulee.dto.WriterResponseDto;
import com.example.schedulee.entitty.Writer;

import java.util.List;

public interface WriterRepository {

    WriterResponseDto saveWriter(Writer writer);

    Boolean findByWriterId(Long id);

    Boolean findByName(String name);
}
