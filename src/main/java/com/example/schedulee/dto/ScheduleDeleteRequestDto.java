package com.example.schedulee.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter
@AllArgsConstructor
public class ScheduleDeleteRequestDto {
    @NotBlank(message = "비밀번호는 필수로 입력해 주셔야 합니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    @Pattern(regexp = ".*[!@#$%^&*(),.?\\\":{}|<>].*", message = "비밀번호는 특수문자를 하나 이상 포함해야 합니다.")
    private String password;
}

