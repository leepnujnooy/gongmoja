# 📈공모자들📈
실시간 공모주 청약 경쟁률 제공 웹 어플리케이션

### 팀 소개
<div align="center">
 
| <p align="center"><img src="https://github.com/gongmoja/gongmoja/assets/108842902/151a9b43-0966-42e2-9e24-d65c5bc87db9"  width="170" height="190"/></p> | <p align="center"><img src="https://github.com/gongmoja/gongmoja/assets/108842902/e00a0c81-c417-4cd5-bcd3-6fb390d6ccb6"  width="170" height="190"/></p> | <p align="center"><img src="https://github.com/gongmoja/gongmoja/assets/108842902/07aa7bb5-7207-4ebc-b709-e8d1ed55995c"  width="170" height="190"/></p> | <p align="center"><img src="https://github.com/gongmoja/gongmoja/assets/108842902/3f2c194d-d9b4-40ee-8ce5-a980be31dfaa"  width="170" height="190"/></p> | <p align="center"><img src="https://github.com/gongmoja/gongmoja/assets/108842902/1c4bec07-85df-45ec-9cd8-3ab379bdcdee"  width="170" height="190"/></p> |
| --- | --- | --- | --- | --- |
| <div align="center">[**김남훈**](https://github.com/namhoon-kim97) </div>| <div align="center">[**여민수**](https://github.com/minsooy)  </div>| <div align="center">[**백성아**](https://github.com/sunga0101)  </div>| <div align="center">[**윤준필**](https://github.com/leepnujnooy)  </div>| <div align="center">[**유다언**](https://github.com/yudaeon)  </div>| 
| <div align="center">**데이터 크롤/시각화/배포**</div> | <div align="center">**웹소켓 채팅/채팅방 관리**</div> | <div align="center">**데이터 크롤/캘린더 연동**</div> | <div align="center">**유저 관리/보안**</div> | <div align="center">**게시판 담당/캘린더 제작** </div>|

</div>

### 프로젝트 정보
- 공모주 별로 복잡한 청약 기간, 환불/상장 일자를 달력으로 간단히 볼 수 있습니다

- 관심가는 종목들은 한번에 마이페이지로 관리하여 지속 트래킹 할 수 있습니다

- 공모주 마다 자유로운 채팅을 통하여 자신의 투자 전략을 맘껏 공유 해볼 수 있습니다

- 항상 클린한 경험을 위하여 비매너 유저들을 신고 할 수 있습니다
 
### 프로젝트 소개
<p align="center"><img src="https://ifh.cc/g/0qdbr4.png"  width="300" height="300"/></p>

<div align="center">
  <img src="https://github.com/gongmoja/gongmoja/assets/124870889/e1bdbe69-cad8-4da8-ae7a-486f222cf700" /><br></br>
  <b>공모자들</b>은 실시간으로 공모주의 정보를 받아볼 수 있는 웹 어플리케이션 입니다.
</div>
<div align="center">
  배포 주소 : <b><a href="http://gongmoja.store" target="_blank">gongmoja.store</a></b>
</div>

### 프로젝트 구조
- 서비스 요청 흐름도
  <img width="878" alt="스크린샷 2023-09-12 오후 5 24 15" src="https://github.com/leepnujnooy/cicdtest/assets/89959383/ee12a705-a4f9-44f5-b248-3746f202f1a7">
  

- CI/CD Workflows
![image](https://github.com/leepnujnooy/cicdtest/assets/89959383/8fb8c3a7-2b5b-4ad3-9503-9d22be699b9f)


### 🛠 구현 기능
### `1.메인페이지`
- 사이드바 스크롤 기능으로 해당 항목 클릭시 이동 가능
- `공모주 정보`, `공모주 일정`, `공모주 경쟁률`, `공모주 뉴스` 확인 가능
- 메인페이지 상단 로그인 페이지 이동

**공모주 일정**
- 크롤 된 공모주 정보, `공모주 일정`에서 확인 가능
- 주식 청약일, 상장일, 환불일 별 별도 표시
- 해당 공모주 클릭시 `공모주 상세페이지` 이동
- 공모주 정보 크롤 사이트(http://www.ipostock.co.kr/sub03/ipo04.asp)

**공모주 경쟁률**
- 현재 시간 이전까지의 데이터만 표시
- 메인페이지 요청할 때마다 갱신
- 08시 이전 데이터는 0으로  표시

**공모주 뉴스(네이버 뉴스 크롤)**
- 최신 공모주 관련 뉴스 3가지 표시
- 10분마다 크롤링
- 제목 누르면 해당 기사로 이동

**공모주 상세페이지**
 - 공모주 일정 혹은 마이페이지 즐겨찾는 공모주 클릭시 해당 공모주 상세페이지로 이동
 - 공모주 `즐겨찾기` 기능
 - 해당 공모주 `채팅방`으로 이동
 - 해당 공모주 크롤 된 주식 정보 확인 가능
 - 해당 공모주 관련 `뉴스 기사` 확인
    
### `2.유저 관리 (인증 & 인가)`
**회원가입**
- 아이디, 이메일은 UNIQUE 한 형태로 서버에 저장
- 비밀번호 입력, 재입력 다를 시 예외처리

**로그인**
- 올바른 아이디, 비밀번호 입력 시 로그인 처리 (`access token`과 `refresh token`을 쿠키형태로 제공 )
- `refresh token`은 서버 내 `redis` 저장소에도 보관하도록 처리 (`access token`재발급 및 유효성 검증 목적 )

**소셜 로그인 (OAuth 2.0)**
- 소셜 인증 성공 시 로그인 처리 (`access token` 과` refresh token` 을 쿠키형태로 제공, 최초 로그인 시 서버에 유저 정보 저장 )

**비밀번호 변경**
- 현재 비밀번호 다를 시 예외처리
- 새로운 비밀번호 입력, 재입력 다를 시 예외처리

**비밀번호 찾기**
- 최초 입력했던 이메일로 임시 비밀번호 전송 (google smtp)


### `3.마이페이지`
**즐겨찾는 공모주**

- 즐겨찾는 공모주 없을 경우
- 즐겨찾는 공모주 있을 경우
- 해당 채팅방으로 이동 및 삭제 가능

**문의하기**
- 일반 사용자의 경우 `내 문의내역` 버튼 활성화
- 관리자의 경우 `전체 문의 내역` 버튼 활성화

**문의사항 등록**
- 첨부파일 업로드 확장자 제한 및 선택 삭제 가능
    
**문의사항 상세페이지**
- 작성자와 관리자만 확인 가능
- 첨부파일 있을 경우 미리보기 가능
- 작성자의 경우 답변 등록 비활성화
- 관리자의 경우 답변 등록 활성화

**내 문의내역 페이지**
 - 관리자 답변 등록시 답변 개수 표시
 - 페이징 및 게시글 오름차순 정렬
    
**관리자로 접근 시**
- 전체문의내역 활성화
- 관리자로 접근시에만 답변 등록 가능하도록 설정
    
### `4.채팅방`
**채팅 기능**
- 본인의 채팅은 좌측에 타인의 채팅은 우측에 표시
- 일별 첫 채팅에는 현재 날짜를 표시
- 관리자 채팅은 공지형식으로 표시됨

**참여중인 채팅방**
- 본인이 참여중인 채팅방의 전체 목록을 보여주고 관리자는 모든 채팅방을 보여준다
- 일반 사용자의 경우 X를 통하여 채팅방을 나갈 수 있다
