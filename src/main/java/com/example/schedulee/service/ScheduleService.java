package com.example.schedulee.service;

import com.example.schedulee.dto.ScheduleRequestDto;
import com.example.schedulee.dto.ScheduleResponseDto;
import com.example.schedulee.entitty.Schedule;

public interface ScheduleService {

    Schedule postSchedule(ScheduleRequestDto dto);
}
