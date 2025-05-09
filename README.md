# **schedule**

***

## 1️⃣ 프로젝트 개요 📋

일정관리 프로그램

🌈 ERD

<img width="639" alt="스크린샷 2025-03-25 오전 1 59 18" src="https://github.com/user-attachments/assets/7fd68663-1461-45f7-8248-47ed1a9a980d" />

🌈 API 명세서

❗️ 링크 1 접속 안될시에 링크 2 접속!

링크 1) 
https://www.notion.so/api-1bd32abd85998048a61fff395cd81cda?pvs=4

링크 2)
https://glen-equinox-8f3.notion.site/api-1bd32abd85998048a61fff395cd81cda?pvs=4

🌈 sql

CREATE DATABASE schedule;
USE schedule;

CREATE TABLE writer (
    writer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    writer_email VARCHAR(255) NOT NULL,
    writer_name VARCHAR(100) NOT NULL,
    writer_created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    writer_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT unique_writer_name UNIQUE (writer_name) 
);

CREATE TABLE schedule (
    schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    todo VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    writer_id BIGINT,
    schedule_date DATETIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_writer
        FOREIGN KEY (writer_id)
        REFERENCES writer(writer_id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);


***

## 2️⃣ 실행 방법 🔨 

1. 필요한 환경 구성하기

- Java Jdk: 17버전
- IDE: IntelliJ IDEA

2. 프로젝트 클론하기

https://github.com/hosung77/schedule

3. Main에서 실행

***
## 3️⃣ Git 전략 ⚡️ 

- gitflow 방식 적용

브랜치는 main, dev, feature/로 나누어 관리하였으며, 기능 개발은 feature 브랜치, 주석을 추가 및 수정은 chore 브랜치, 긴급 수정은 fix 브랜치에서 진행한 후,
기능 단위로 dev 브랜치에 Pull Request를 통해 병합하였다. 전체 기능 개발이 완료되면, dev 브랜치를 main에 병합하여 최종 코드를 반영하였다.

## 4️⃣ 브랜치 개발 순서 🔨

feature/nec_1 -> feature/nec_2 -> feature/chall_lv3 ->  feature/chall_lv4 ->  feature/chall_lv5 ->  feature/chall_lv6 -> chore/update-comments -> chore/update-comments-v2 -> fix/chall_lv3-missing-implementation -> fix/delete-controller-parameter -> chore/update-comments-v3 -> fix/get-all-schedules

## 5️⃣ 주요 기능 ⚙️

### ✅ **사용자 등록**

사용자의 이름과 이메일을 입력하여 사용자를 등록할 수 있다.

### ✅ **일정 등록**

일정 및 일정 시간 등을 가지고 일정을 등록할 수 있다.

### ✅ **전체 일정 조회하기**

전체 일정을 조회할 수 있다.

### ✅ **작성자의 전체 일정 불러오기**

작성자에게 부여된 고유한 id를 이용하여 작성자의 작성글들을 모두 조회할 수 있다.

### ✅ **일정 수정**

일정에 부여된 교유한 id를 가지고 작성자 이름 및 To do를 수정할 수 있다. 

### ✅ **일정 삭제**

일정에 부여된 id를 가지고 일정을 삭제할 수 있다.






