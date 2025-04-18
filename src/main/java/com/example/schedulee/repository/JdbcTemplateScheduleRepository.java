package com.example.schedulee.repository;

import com.example.schedulee.dto.*;
import com.example.schedulee.entitty.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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
import java.util.Optional;

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
        params.put("writer_id", sc.getWriterId());
        params.put("password", sc.getPassword());
        params.put("scheduleDate", sc.getScheduleDate());
        params.put("created_at", sc.getCreatedAt());
        params.put("modified_at", sc.getModifiedAt());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(params));


        return new ScheduleResponseDto(
                key.longValue(),
                sc.getTodo(),
                sc.getWriterId(),
                sc.getCreatedAt(),
                sc.getModifiedAt(),
                sc.getScheduleDate()
        );
    }

    @Override
    public List<AllScheduleDto> findAllSchedule() {
        return jdbcTemplate.query(
                "SELECT s.schedule_id, s.todo, w.writer_id, w.writer_name, s.schedule_date " +
                        "FROM schedule s " +
                        "JOIN writer w ON s.writer_id = w.writer_id ",
                scheduleAllDtoRowMapper()
        );
    }


    // schedule 테이블에서 todo와 modified_at 업데이트
    public void updateScheduleTodo(String todo, Long id) {
        jdbcTemplate.update(
                "UPDATE schedule SET todo = ?, modified_at = ? WHERE schedule_id = ?",
                todo,
                LocalDateTime.now(), // 수정된 시간
                id
        );
    }

    // writer 테이블에서 writer_name과 writer_modified_at 업데이트
    public void updateWriterName(String writerName, Long id) {
        jdbcTemplate.update(
                "UPDATE writer SET writer_name = ?, writer_modified_at = ? WHERE writer_id = (SELECT writer_id FROM schedule WHERE schedule_id = ?)",
                writerName,
                LocalDateTime.now(), // 수정된 시간
                id
        );
    }

    @Override
    public Optional<Schedule> findByScheduleId(Long id) {
        try {
            Schedule schedule = jdbcTemplate.queryForObject(
                    "SELECT * FROM schedule WHERE schedule_id = ?",
                    scheduleRowMapper(),
                    id
            );
            return Optional.ofNullable(schedule);  // 결과가 있는 경우 Optional로 감싸서 반환
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();  // 결과가 없을 경우 Optional.empty() 반환
        }
    }



    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete from schedule where schedule_id = ?", id);
    }

    @Override
    public Optional<List<SearchedScheduleDto>> findScheduleByWriterID(Long id) {
        List<SearchedScheduleDto> result = jdbcTemplate.query(
                "SELECT s.schedule_id, w.writer_id, w.writer_name, w.writer_email, " +
                        "s.todo, s.schedule_date, s.created_at, s.modified_at " +
                        "FROM schedule s " +
                        "JOIN writer w ON s.writer_id = w.writer_id " +
                        "WHERE w.writer_id = ?",
                searchedScheduleDtoRowMapper(),
                id
        );

        return result.isEmpty() ? Optional.empty() : Optional.of(result);
    }


    @Override
    public SearchedScheduleDto findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT s.schedule_id, w.writer_id, w.writer_name, w.writer_email, s.todo, s.schedule_date, s.created_at, s.modified_at " +
                        "FROM schedule s " +
                        "JOIN writer w ON s.writer_id = w.writer_id " +
                        "WHERE s.schedule_id = ?",
                searchedScheduleDtoRowMapper(),
                id
        );
    }



    private RowMapper<AllScheduleDto> scheduleAllDtoRowMapper(){

        return new RowMapper<AllScheduleDto>() {
            @Override
            public AllScheduleDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new AllScheduleDto(
                        rs.getLong("schedule_id"),
                        rs.getString("todo"),
                        rs.getString("writer_id"),
                        rs.getString("writer_name"),
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
                        rs.getLong("writer_id"),
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
                        rs.getLong("writer_id"),
                        rs.getObject("created_at", LocalDateTime.class),
                        rs.getObject("modified_at", LocalDateTime.class),
                        rs.getObject("schedule_date", LocalDateTime.class)
                );
            }
        };
    }

    private RowMapper<SearchedScheduleDto> searchedScheduleDtoRowMapper(){
        return new RowMapper<SearchedScheduleDto>() {
            @Override
            public SearchedScheduleDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new SearchedScheduleDto(
                        rs.getLong("schedule_id"),
                        rs.getLong("writer_id"),
                        rs.getString("writer_name"),
                        rs.getString("writer_email"),
                        rs.getString("todo"),
                        rs.getObject("created_at", LocalDateTime.class),
                        rs.getObject("modified_at", LocalDateTime.class),
                        rs.getObject("schedule_date", LocalDateTime.class)
                );
            }
        };
    }
}
