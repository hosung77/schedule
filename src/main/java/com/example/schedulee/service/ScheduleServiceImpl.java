package com.example.schedulee.service;

import com.example.schedulee.dto.ScheduleRequestDto;
import com.example.schedulee.dto.ScheduleResponseDto;
import com.example.schedulee.entitty.Schedule;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Override
    public Schedule postSchedule(ScheduleRequestDto dto) {
        Schedule sc = new Schedule(dto.getScheduleId(), dto.getTodo(),dto.getWriter(),dto.getCreatedAt(),dto.getModifiedAt());
    }
}
