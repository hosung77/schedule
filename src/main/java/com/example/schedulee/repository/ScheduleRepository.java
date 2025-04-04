package com.example.schedulee.repository;

import com.example.schedulee.dto.*;
import com.example.schedulee.entitty.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule sc);

    List<AllScheduleDto> findAllSchedule();

    Optional<Schedule> findByScheduleId(Long id);

    void deleteById(Long id);

    Optional<List<SearchedScheduleDto>> findScheduleByWriterID(Long id);

    SearchedScheduleDto findById(Long id);

    void updateScheduleTodo(String todo, Long id);

    void updateWriterName(String writerName, Long id);

}
