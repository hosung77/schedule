package com.example.schedulee.service;

import com.example.schedulee.dto.*;
import com.example.schedulee.entitty.Schedule;
import com.example.schedulee.exception.CustomException;
import com.example.schedulee.exception.ErrorCode;
import com.example.schedulee.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponseDto postSchedule(ScheduleRequestDto dto) {
        if (dto.getCreatedAt() == null && dto.getModifiedAt() == null) {
            dto.setCreatedAt(LocalDateTime.now());
            dto.setModifiedAt(LocalDateTime.now());
        }

        Schedule sc = new Schedule(null, dto.getTodo(),dto.getWriterId(),dto.getPassword(),dto.getScheduleDate(),dto.getCreatedAt(),dto.getModifiedAt());
        return scheduleRepository.saveSchedule(sc);
    }

    @Override
    public Paging<ScheduleAllDto> searchAllWithPaging(ScheduleRequestAllDto sc, int page, int size) {

        List<ScheduleAllDto> searchedResult = scheduleRepository.findByNameOrCreatedAt(sc);

        // 전체 데이터 개수
        long totalElements = searchedResult.size();

        // 페이지에 맞는 데이터를 추출
        // page 번호와 size (한 페이지의 항목 수)를 이용하여 데이터의 시작 인덱스를 계산합니다. 예를 들어, page=1, size=10이면, 첫 번째 페이지의 시작 인덱스는 0
        int fromIndex = (page - 1) * size;

        // fromIndex에서 한 페이지의 크기인 size만큼 데이터를 추출할 끝 인덱스를 계산
        // Math.min을 사용한 이유는 리스트의 사이즈가 fromIndex + size의 값보다 클수도 있기 때문이다.
        int toIndex = Math.min(fromIndex + size, searchedResult.size());

        // fromIndex가 리스트의 크기보다 크면 값을 초과하기 때문에 빈배열을 반환해주고 그게 아니라면
        // fromIndex와 toIndex 사이의 값을 반환해준다.
        List<ScheduleAllDto> pagedContent = (fromIndex >= searchedResult.size()) ?
                Collections.emptyList() : searchedResult.subList(fromIndex, toIndex);

        // 전체 페이지 개수 계산
        // Math.ceil은 소수점을 반올림해서 올려주는 함수이다. 12/10을 했을 경우 1.2 이지만 페이지 갯수는 총 2페이지이다.
        // ceil을 사용하여 이 점을 충족해준다.
        int totalPages = (int) Math.ceil((double) totalElements / size);

        // Paging 객체 반환
        return new Paging<>(pagedContent, page, size, totalElements, totalPages);

    }


    @Override
    public SearchedScheduleDto editInfo(ScheduleEditRequestDto dto, Long id) {
        if (id == null) {
            throw new CustomException(ErrorCode.INVALID_ID);
        }

        // 수정 요청을 받은 DTO의 비밀번호와 DB에 저장된 비밀번호를 비교하기 위해,
        // PathVariable로 전달된 id를 사용하여 DB에서 해당 일정 정보를 조회하고 임시 변수에 할당
        Schedule schedule = scheduleRepository.findByScheduleId(id)
                .orElseThrow(() -> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND));

        // 조건문을 통해 비밀번호 비교 후 같으면 수정 다르면 예외를 발생시킨다.
        if (schedule.getPassword().equals(dto.getPassword())) {
            scheduleRepository.updateSchedule(dto, id);

            // 업데이트된 정보를 dto에 담아 반환
            SearchedScheduleDto updatedSchedule = scheduleRepository.findById(id);

            return updatedSchedule;
        } else {
            // 비밀번호가 다르면 사용자에게 알림 처리
            throw new CustomException(ErrorCode.PASSWORD_NOT_MATCH);
        }
    }

    @Override
    public void deleteSchedule(ScheduleDeleteRequestDto dto) {
        if (dto.getId() == null) {
            throw new CustomException(ErrorCode.INVALID_ID);
        }
        // 삭제 요청을 받은 DTO의 비밀번호와 DB에 저장된 비밀번호를 비교하기 위해,
        // PathVariable로 전달된 Dto에 id를 사용하여 DB에서 해당 일정 정보를 조회하고 임시 변수에 할당
        Schedule schedule = scheduleRepository.findByScheduleId(dto.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND));

        // 조건문을 통해 비밀번호 비교 후 같으면 수정 다르면 예외를 발생시킨다.
        if (schedule.getPassword().equals(dto.getPassword())) {
            scheduleRepository.deleteById(dto.getId());
        } else {
            // 비밀번호가 다르면 사용자에게 알림 처리
            throw new CustomException(ErrorCode.PASSWORD_NOT_MATCH);
        }
    }

    @Override
    public List<SearchedScheduleDto> searchSchedule(Long id) {
        List<SearchedScheduleDto> result = scheduleRepository.findScheduleByID(id)
                .orElseThrow(()->new CustomException(ErrorCode.SCHEDULE_NOT_FOUND));
        return result;
    }

}
