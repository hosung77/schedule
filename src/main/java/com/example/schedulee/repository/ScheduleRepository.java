package com.example.schedulee.repository;

import com.example.schedulee.dto.*;
import com.example.schedulee.entitty.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule sc);

    List<ScheduleAllDto> findByNameOrCreatedAt(ScheduleRequestAllDto sc);

    void updateSchedule(ScheduleEditRequestDto dto, Long id);

    Schedule findByScheduleId(Long id);

    void deleteById(Long id);

    List<SearchedScheduleDto> findScheduleByID(Long id);

    SearchedScheduleDto findById(Long id);

}
