package com.example.schedulee.repository;

import com.example.schedulee.dto.ScheduleAllDto;
import com.example.schedulee.dto.ScheduleEditRequestDto;
import com.example.schedulee.dto.ScheduleRequestAllDto;
import com.example.schedulee.dto.ScheduleResponseDto;
import com.example.schedulee.entitty.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public ScheduleResponseDto saveSchedule(Schedule sc) {


        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("schedule") // 테이블 이름
                .usingGeneratedKeyColumns("schedule_id"); // 자동 생성되는 pk명

        Map<String, Object> params = new HashMap<>();
        params.put("todo", sc.getTodo());
        params.put("writer", sc.getWriter());
        params.put("password", sc.getPassword());
        params.put("scheduleDate", sc.getScheduleDate());
        params.put("created_at", sc.getCreatedAt());
        params.put("modified_at", sc.getModifiedAt());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(params));


        return new ScheduleResponseDto(
                key.longValue(),
                sc.getTodo(),
                sc.getWriter(),
                sc.getCreatedAt(),
                sc.getModifiedAt(),
                sc.getScheduleDate()
        );
    }

    @Override
    public List<ScheduleAllDto> findByNameOrCreatedAt(ScheduleRequestAllDto sc) {
        return jdbcTemplate.query("select * from schedule where Date(modified_at) = ? or writer = ? order by modified_at desc", scheduleAllDtoRowMapper(), sc.getModifiedAt(), sc.getWriter());
    }

    @Override
    public ScheduleResponseDto findById(Long id) {
        return jdbcTemplate.queryForObject("select * from schedule where schedule_id = ?", scheduleResponseDtoRowMapper(),id);
    }



    @Override
    public void updateSchedule(ScheduleEditRequestDto dto, Long id) {
        LocalDateTime now = LocalDateTime.now(); // 현재 시간
        jdbcTemplate.update("update schedule set todo = ?, writer = ?, modified_at = ? where schedule_id= ?", dto.getTodo(),dto.getWriter(),now,id);
    }

    @Override
    public Schedule findByScheduleId(Long id) {
       return jdbcTemplate.queryForObject("select * from schedule where schedule_id = ?",scheduleRowMapper() ,id);
    }


    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from schedule where schedule_id = ?", id);
    }


    private RowMapper<ScheduleAllDto> scheduleAllDtoRowMapper(){

        return new RowMapper<ScheduleAllDto>() {
            @Override
            public ScheduleAllDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleAllDto(
                        rs.getLong("schedule_id"),
                        rs.getString("todo"),
                        rs.getString("writer"),
                        rs.getObject("created_at", LocalDateTime.class),
                        rs.getObject("modified_at", LocalDateTime.class),
                        rs.getObject("schedule_date", LocalDateTime.class)
                );
            }
        };
    }

    private RowMapper<Schedule> scheduleRowMapper(){

        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("schedule_id"),
                        rs.getString("todo"),
                        rs.getString("writer"),
                        rs.getString("password"),
                        rs.getObject("created_at", LocalDateTime.class),
                        rs.getObject("modified_at", LocalDateTime.class),
                        rs.getObject("schedule_date", LocalDateTime.class)
                );
            }
        };
    }
    private RowMapper<ScheduleResponseDto> scheduleResponseDtoRowMapper(){

        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("schedule_id"),
                        rs.getString("todo"),
                        rs.getString("writer"),
                        rs.getObject("created_at", LocalDateTime.class),
                        rs.getObject("modified_at", LocalDateTime.class),
                        rs.getObject("schedule_date", LocalDateTime.class)
                );
            }
        };
    }
}
