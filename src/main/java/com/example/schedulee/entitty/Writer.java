package com.example.schedulee.entitty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Writer {

    private Long writerId;
    private String writerEmail;
    private String writerName;
    private LocalDateTime writerCreatedAt;
    private LocalDateTime writerModifiedAt;

}
