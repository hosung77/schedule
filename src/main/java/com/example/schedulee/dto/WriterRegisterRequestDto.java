package com.example.schedulee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Setter
public class WriterRegisterRequestDto {
    @NotBlank(message = "이메일을 필수로 입력해 주셔야 합니다.")
    @Email(message = "이메일 형식에 맞게 입력해 주세요.")
    private String email;

    @NotBlank(message = "이름은 필수로 입력해 주셔야 합니다.")
    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
