package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class ScheduleEditRequestDto {
    String todo;
    String writer;
    String password; // 수정을 하기 위해 필요한 비밀번호
}
