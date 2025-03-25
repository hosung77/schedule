package com.example.schedulee.service;

import com.example.schedulee.dto.*;
import com.example.schedulee.entitty.Schedule;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto postSchedule(ScheduleRequestDto dto);

    Paging<ScheduleAllDto> searchAllWithPaging(ScheduleRequestAllDto sc, int page, int size);

    SearchedScheduleDto editInfo(ScheduleEditRequestDto dto, Long id);

    void deleteSchedule(ScheduleDeleteRequestDto dto);

    List<SearchedScheduleDto> searchSchedule(Long id);
}
