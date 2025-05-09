package com.example.schedulee.service;

import com.example.schedulee.dto.*;


import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto postSchedule(ScheduleRequestDto dto);

    Paging<AllScheduleDto> searchAllWithPaging(int page, int size);

    SearchedScheduleDto editInfo(ScheduleEditRequestDto dto, Long id);

    void deleteSchedule(ScheduleDeleteRequestDto dto, Long scheduleId);

    List<SearchedScheduleDto> searchSchedule(Long id);
}
