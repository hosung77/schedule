package com.example.schedulee.repository;

import com.example.schedulee.dto.WriterResponseDto;
import com.example.schedulee.entitty.Writer;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateWriterRepository implements WriterRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public WriterResponseDto saveWriter(Writer wr) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("writer") // 테이블 이름
                .usingGeneratedKeyColumns("writer_id"); // 자동 생성되는 pk명

        Map<String, Object> params = new HashMap<>();
        params.put("writer_email", wr.getWriterEmail());
        params.put("writer_name", wr.getWriterName());
        params.put("writer_created_at", wr.getWriterCreatedAt());
        params.put("modified", wr.getWriterModifiedAt());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(params));


        return new WriterResponseDto(
                key.longValue(),
                wr.getWriterEmail(),
                wr.getWriterName(),
                wr.getWriterCreatedAt(),
                wr.getWriterModifiedAt()
        );
    }

    @Override
    public Boolean findByWriterId(Long id) {
        String sql = "SELECT COUNT(*) FROM writer WHERE writer_id = ?";  // users 테이블에서 id가 일치하는 행을 조회

        // COUNT(*)가 1 이상이면 존재한다는 의미
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count != null && count > 0;  // count가 1 이상이면 존재, 아니면 존재하지 않음
    }

    @Override
    public Boolean findByName(String name) {
        String sql = "SELECT COUNT(*) FROM writer WHERE writer_name = ?";  // users 테이블에서 id가 일치하는 행을 조회

        // COUNT(*)가 1 이상이면 존재한다는 의미
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, name);

        return count != null && count > 0;  // count가 1 이상이면 존재, 아니면 존재하지 않음
    }


}

