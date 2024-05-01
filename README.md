
## 1단계 기능 요구 사항

- 예외 상황 처리 (엄청 많이)
  - 예약
    - 예약자명, 날짜, 시간에 유효하지 않은 값이 입력 되었을 때
        - [x] 날짜가 형식에 맞지 않을 때 
        - [x] 날짜/시간id/예약자명 중 하나라도 비어있을 때
    - [x] 지나간 날짜와 시간에 대한 예약 생성은 불가
    - [x] 해당 시간id가 시간 테이블에 없을 때
    - [ ] 중복 예약(시간, 날짜와 테마가 동일할 때)은 불가 
  - 시간
    - 시작 시간에 유효하지 않은 값이 입력되었을 때
      - [x] 시간이 형식에 맞지 않을 때
      - [x] 시간이 비워있을 때
    - [x] 특정 시간에 대한 예약이 존재하는데, 그 시간을 삭제하려 할 때
    - [x] 중복된 시간은 불가

- [x] 위의 예외가 발생할 경우, 400 Bad Request를 응답한다.
  - [x] body에는 예외 메시지가 들어간다.
    ```text
    {
      errorMessage : "날짜(20_20_20)가 yyyy-MM-dd에 맞지 않습니다."
    }
    ```

- [x] 어드민의 시간 관리 페이지, 
  - 방탈출 예약 페이지에서 모든 기능이 정상적으로 동작하는지 확인

## 2단계 기능 요구 사항

- [x] /admin/theme 요청 시 테마 관리 페이지를 응답
- [x] 어드민에서 방탈출 예약 페이지 변경

- '테마' 도메인 추가 (id, name, description, thumbnail)
  - [x] 유효성 검사
- [x] 테마를 조회할 수 있다.
- [x] 테마를 추가할 수 있다.
  - [x] 중복된 이름의 테마 불가
- [x] 테마를 삭제할 수 있다.
  - [x] 이미 예약이 존재하는 경우, 테마 삭제 불가

- 예약 도메인 변경
  - [x] 테마 객체 추가

## 3단계 기능 요구 사항

- [ ] /reservation 요청 시 사용자 예약 페이지 응답
- [ ] / 요청 시 인기 테마 페이지 응답

- 사용자 방탈출 예약
  - [ ] 날짜와 테마가 주어지면, 해당 날짜에 예약 가능한 시간을 조회할 수 있다.
    - [ ] 가능한 시간인 경우, alreadyBooked을 true
    - [ ] 불가능한 시간인 경우, alreadyBooked을 false
  - [ ] 사용자는 원하는 날짜, 테마, 시간, 예약자명으로 예약할 수 있다.

- 인기 테마 조회
  - [ ] 현재 날짜 이전 일주일을 기준으로, 해당 기간 내에 방문하는 예약이 많은 테마 10개를 조회할 수 있다.
    - ex. 오늘이 4/8 -> 4/1 ~ 4/7

- [ ] `ranking.js` render 함수에서 사용할 data에는 (name, thumbnail, description)이 있어야 함
- [ ] `user-reservation.js` renderTheme 함수, fetchAvailableTimes 함수 등 수정
