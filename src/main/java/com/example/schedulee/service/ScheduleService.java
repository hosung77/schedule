package com.example.schedulee.service;

import com.example.schedulee.dto.*;
import com.example.schedulee.entitty.Schedule;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto postSchedule(ScheduleRequestDto dto);

    List<ScheduleAllDto> searchAll(ScheduleRequestAllDto sc);

    ScheduleResponseDto searchSchedule(Long id);

    ScheduleResponseDto editInfo(ScheduleEditRequestDto dto, Long id);

    void deleteSchedule(Long id);
}
