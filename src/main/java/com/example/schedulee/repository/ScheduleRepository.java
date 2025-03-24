package com.example.schedulee.repository;

import com.example.schedulee.dto.ScheduleAllDto;
import com.example.schedulee.dto.ScheduleRequestAllDto;
import com.example.schedulee.dto.ScheduleResponseDto;
import com.example.schedulee.entitty.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule sc);

    List<ScheduleAllDto> findByNameOrCreatedAt(ScheduleRequestAllDto sc);

    ScheduleResponseDto findById(Long id);
}
