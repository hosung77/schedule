# **schedule**

***

## 1️⃣ 프로젝트 개요 📋

일정관리 프로그램

🌈 ERD

<img width="639" alt="스크린샷 2025-03-25 오전 1 59 18" src="https://github.com/user-attachments/assets/7fd68663-1461-45f7-8248-47ed1a9a980d" />

🌈 API 명세서

https://glen-equinox-8f3.notion.site/api-1bd32abd85998048a61fff395cd81cda?pvs=4

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

브랜치는 main, dev, feature/로 나누어 관리하였으며, 기능 개발은 feature 브랜치에서 진행한 후,
기능 단위로 dev 브랜치에 Pull Request를 통해 병합하였다. 전체 기능 개발이 완료되면, dev 브랜치를 main에 병합하여 최종 코드를 반영하였다.

## 4️⃣ 브랜치 개발 순서 🔨

feature/nec_1 -> feature/nec_2 -> feature/chall_lv3 ->  feature/chall_lv4 ->  feature/chall_lv5 ->  feature/chall_lv6 -> chore/update-comments -> chore/update-comments-v2 -> fix/chall_lv3-missing-implementation

## 5️⃣ 주요 기능 ⚙️

### ✅ **사용자 등록**

사용자의 이름과 이메일을 입력하여 사용자를 등록할 수 있다.

### ✅ **일정 등록**

일정 및 일정 시간등을 가지고 일정을 등록할 수 있다.

### ✅ **특정 일정 불러오기**

일정에 부여된 id를 가지고 특정 일정을 찾을 수 있다.

### ✅ **전체 일정 불러오기**

일정의 작성자의 이름 또는 일정의 시간을 입력하면 두 조건 중 만족하는 결과 전체를 보여준다.

### ✅ **일정 삭제**

일정에 부여된 id를 가지고 일정을 삭제할 수 있다.

### ✅ *장바구니 삭제 기능*

장바구니 목록 확인 후 특정 번호를 입력하면 특정 메뉴를 삭제할 수 있다.




