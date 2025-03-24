package com.example.schedulee.service;

import com.example.schedulee.dto.ScheduleAllDto;
import com.example.schedulee.dto.ScheduleRequestAllDto;
import com.example.schedulee.dto.ScheduleRequestDto;
import com.example.schedulee.dto.ScheduleResponseDto;
import com.example.schedulee.entitty.Schedule;
import com.example.schedulee.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final JdbcTemplate jdbcTemplate;


    @Override
    public ScheduleResponseDto postSchedule(ScheduleRequestDto dto) {
        if (dto.getCreatedAt() == null && dto.getModifiedAt() == null) {
            dto.setCreatedAt(LocalDateTime.now());
            dto.setModifiedAt(LocalDateTime.now());
        }

        Schedule sc = new Schedule(null, dto.getTodo(),dto.getWriter(),dto.getPassword(),dto.getScheduleDate(),dto.getCreatedAt(),dto.getModifiedAt());
        return scheduleRepository.saveSchedule(sc);
    }

    @Override
    public List<ScheduleAllDto> searchAll(ScheduleRequestAllDto sc) {

        List<ScheduleAllDto> searchedResult = scheduleRepository.findByNameOrCreatedAt(sc);
        return searchedResult;

    }

    @Override
    public ScheduleResponseDto searchSchedule(Long id) {

        ScheduleResponseDto selectedResult = scheduleRepository.findById(id);
        return selectedResult;
    }


}
