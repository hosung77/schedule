package com.example.schedulee.service;

import com.example.schedulee.dto.*;
import com.example.schedulee.entitty.Schedule;
import com.example.schedulee.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final JdbcTemplate jdbcTemplate;


    @Override
    public ScheduleResponseDto postSchedule(ScheduleRequestDto dto) {
        if (dto.getCreatedAt() == null && dto.getModifiedAt() == null) {
            dto.setCreatedAt(LocalDateTime.now());
            dto.setModifiedAt(LocalDateTime.now());
        }

        Schedule sc = new Schedule(null, dto.getTodo(),dto.getWriter(),dto.getPassword(),dto.getScheduleDate(),dto.getCreatedAt(),dto.getModifiedAt());
        return scheduleRepository.saveSchedule(sc);
    }

    @Override
    public List<ScheduleAllDto> searchAll(ScheduleRequestAllDto sc) {

        List<ScheduleAllDto> searchedResult = scheduleRepository.findByNameOrCreatedAt(sc);
        return searchedResult;

    }

    @Override
    public ScheduleResponseDto searchSchedule(Long id) {

        ScheduleResponseDto selectedResult = scheduleRepository.findById(id);
        return selectedResult;
    }

    @Override
    public ScheduleResponseDto editInfo(ScheduleEditRequestDto dto, Long id) {

        // 수정 요청을 받은 DTO의 비밀번호와 DB에 저장된 비밀번호를 비교하기 위해,
        // PathVariable로 전달된 id를 사용하여 DB에서 해당 일정 정보를 조회하고 임시 변수에 할당
        Schedule schedule = scheduleRepository.findByScheduleId(id);

        // 조건문을 통해 비밀번호 비교 후 같으면 수정 다르면 예외를 발생시킨다.
        if (schedule.getPassword().equals(dto.getPassword())) {
            scheduleRepository.updateSchedule(dto, id);

            // 업데이트된 정보 다시 조회
            Schedule updatedSchedule = scheduleRepository.findByScheduleId(id);

            // 업데이트된 Schedule을 DTO로 변환하여 반환
            return new ScheduleResponseDto(updatedSchedule);
        } else {
            // 비밀번호가 다르면 사용자에게 알림 처리
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    @Override
    public void deleteSchedule(Long id) {
        // 삭제 요청을 받은 DTO의 비밀번호와 DB에 저장된 비밀번호를 비교하기 위해,
        // PathVariable로 전달된 id를 사용하여 DB에서 해당 일정 정보를 조회하고 임시 변수에 할당
        Schedule schedule = scheduleRepository.findByScheduleId(id);

        // 조건문을 통해 비밀번호 비교 후 같으면 수정 다르면 예외를 발생시킨다.
        if (schedule.getPassword().equals(id)) {
            scheduleRepository.deleteById(id);
        } else {
            // 비밀번호가 다르면 사용자에게 알림 처리
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }


}
