package com.example.schedulee.service;

import com.example.schedulee.dto.ScheduleAllDto;
import com.example.schedulee.dto.ScheduleRequestAllDto;
import com.example.schedulee.dto.ScheduleRequestDto;
import com.example.schedulee.dto.ScheduleResponseDto;
import com.example.schedulee.entitty.Schedule;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto postSchedule(ScheduleRequestDto dto);

    List<ScheduleAllDto> searchAll(ScheduleRequestAllDto sc);

    ScheduleResponseDto searchSchedule(Long id);
}
