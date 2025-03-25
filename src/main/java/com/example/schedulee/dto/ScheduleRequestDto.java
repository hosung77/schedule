package com.example.schedulee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Setter
public class ScheduleRequestDto {
    @NotBlank(message = "Todo는 필수로 입력해 주셔야 합니다.")
    @Size(max = 200, message = "할일은 200자 이내로 입력해주세요.")
    private String todo;

    @NotBlank(message = "작성자 아이디는 필수로 입력해 주셔야 합니다.")
    private String writerId;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @NotBlank(message = "비밀번호는 필수로 입력해 주셔야 합니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상(영문자 + 특수문자 1개 이상)이어야 합니다.")
    @Pattern(regexp = ".*[!@#$%^&*(),.?\\\":{}|<>].*", message = "비밀번호는 특수문자를 하나 이상 포함해야 합니다.")
    private String password;

    private LocalDateTime scheduleDate;
}
