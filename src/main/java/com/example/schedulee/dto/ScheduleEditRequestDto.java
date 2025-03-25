package com.example.schedulee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Getter
@AllArgsConstructor
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 값은 직렬화하지 않음
public class ScheduleEditRequestDto {

    @Nullable
    @Size(max = 200, message = "할일은 200자 이내로 입력해주세요.")
    String todo;

    @Nullable
    String writerName;

    @NotBlank(message = "비밀번호는 필수로 입력해 주셔야 합니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    @Pattern(regexp = ".*[!@#$%^&*(),.?\\\":{}|<>].*", message = "비밀번호는 특수문자를 하나 이상 포함해야 합니다.")
    String password; // 수정을 하기 위해 필요한 비밀번호
}
