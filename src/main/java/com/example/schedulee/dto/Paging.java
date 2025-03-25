package com.example.schedulee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Paging<T> {

    private final List<T> content; // 현재 페이지 데이터
    private final int page; // 현재 페이지 번호
    private final int size; // 페이지 크기
    private final long totalElements; // 전체 데이터 개수
    private final int totalPages; // 전체 페이지 개수

}
