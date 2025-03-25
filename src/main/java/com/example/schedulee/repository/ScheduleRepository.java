package com.example.schedulee.repository;

import com.example.schedulee.dto.*;
import com.example.schedulee.entitty.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule sc);

    List<ScheduleAllDto> findByNameOrCreatedAt(ScheduleRequestAllDto sc);

    void updateSchedule(ScheduleEditRequestDto dto, Long id);

    Optional<Schedule> findByScheduleId(Long id);

    void deleteById(Long id);

    Optional<List<SearchedScheduleDto>> findScheduleByID(Long id);

    SearchedScheduleDto findById(Long id);

}
