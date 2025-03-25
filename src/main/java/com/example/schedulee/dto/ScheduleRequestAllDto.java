package com.example.schedulee.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleRequestAllDto {
    @NotBlank(message = "작성자 이름은 필수로 입력해 주셔야 합니다.")
    private String writerName;

    @NotBlank(message = "수정일시는 필수로 필수로 입력해 주셔야 합니다.")
    private LocalDateTime modifiedAt;
}
