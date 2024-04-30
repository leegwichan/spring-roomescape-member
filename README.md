
## 1단계 기능 요구 사항

- 예외 상황 처리 (엄청 많이)
  - 예약
    - 예약자명, 날짜, 시간에 유효하지 않은 값이 입력 되었을 때
        - [x] 날짜가 형식에 맞지 않을 때 
        - [x] 날짜/시간id/예약자명 중 하나라도 비어있을 때
    - [x] 지나간 날짜와 시간에 대한 예약 생성은 불가
    - [x] 해당 시간id가 시간 테이블에 없을 때
    - [x] 중복 예약(시간과 날짜가 동일할 때)은 불가 
  - 시간
    - 시작 시간에 유효하지 않은 값이 입력되었을 때
      - [x] 시간이 형식에 맞지 않을 때
      - [x] 시간이 비워있을 때
    - [x] 특정 시간에 대한 예약이 존재하는데, 그 시간을 삭제하려 할 때
    - [x] 중복된 시간은 불가

- [ ] 위의 예외가 발생할 경우, 400 Bad Request를 응답한다.
  - [ ] body에는 예외 메시지가 들어간다.
    ```text
    {
      message : "날짜(20_20_20)가 yyyy-MM-dd에 맞지 않습니다."
    }
    ```

- [x] 어드민의 시간 관리 페이지, 
  - 방탈출 예약 페이지에서 모든 기능이 정상적으로 동작하는지 확인
