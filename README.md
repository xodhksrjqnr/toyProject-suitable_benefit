# ToyProject-Suitable_Benefit

### 소개

지원 정책이나 혜택은 다양하고 많지만, 정작 자신에게 필요한 것을 찾기란 쉽지 않고 찾기위해 
많은 시간을 필요로 합니다. 이런 문제점을 해결하고자 지원 정책과 혜택의 정보를 한 눈에 확인할 
수 있고, 자신에게 해당하는 것만을 골라 볼 수 있는 서비스 구현을 목표로 하였습니다.

### 기간 & 사용기술

개발기간 : 2022.08 ~ 진행중

사용기술 : Spring Boot, Spring Data JPA, ReactJS, MySQL

### 구조

<img width="787" alt="architecture" src="https://user-images.githubusercontent.com/48250370/201510827-e897b834-d8ad-4f1d-89bd-c029531c631a.png">

### 구현 상태

Client Front Server
- 등록된 혜택 게시물을 무한 횡스크롤 방식으로 출력
- 우측 상단의 필터 버튼 클릭 후 원하는 조건을 선택하여 게시물 필터링
- 출력된 게시물은 SimpleInfo(포스터이미지, 타이틀, D-day, 적합률, 태그)를 표시
- 특정 게시물 클릭시 해당 게시물의 DetailInfo(SimpleInfo, 지원 내용, 남은 시간, 혜택 url)를 표시

<img width="787" alt="client_post" src="https://user-images.githubusercontent.com/48250370/201512520-686a06b9-71ae-4601-afb5-4e1abbf41723.png">

<img width="787" alt="client_filter" src="https://user-images.githubusercontent.com/48250370/201512526-230befdd-b268-4de5-b0cd-78fa3a70f598.png">

Admin Front Server
- 유지보수를 위한 사이드바 기능(홈페이지 이동, Dashboard, UploadForm)
- Dashboard : 등록된 게시물 리스트 확인, 특정 게시물 공개 여부 변경, 등록된 태그 리스트 확인, 태그 등록
- UploadForm : 게시물 등록, 포스터 preview

<img width="787" alt="amdin" src="https://user-images.githubusercontent.com/48250370/201512518-d49f1e3a-52c3-4349-b628-4197aae1285b.png">

API Server
- Post

  |설명|API|비고|
  |---|---|---|
  |게시물조회|GET /posts/{postId}||
  |공개게시물전체조회|GET /posts/{cursor}/{filter}|filter = 0 : 태그 x, filter != 0 : 태그 o|
  |게시물전체조회|GET /posts/detail||
  |게시물저장|POST /posts||
  |게시물공개여부변경|POST /posts/{postId}/activity||
  
- Tag

  |설명|API|비고|
  |---|---|---|
  |태그전체조회|GET /tags||
  |태그저장|POST /tags/{name}||

### 생각 정리

- [SPA? MPA?](https://github.com/xodhksrjqnr/toyProject-suitable_benefit/wiki/SPA,-MPA)
- [Cursor vs Offset](https://github.com/xodhksrjqnr/toyProject-suitable_benefit/wiki/Cursor-vs-Offset)
- [태그 저장 방식 & 호출 방식](https://github.com/xodhksrjqnr/toyProject-suitable_benefit/wiki/%ED%83%9C%EA%B7%B8-%EC%A0%80%EC%9E%A5-%EB%B0%A9%EC%8B%9D-&-%ED%98%B8%EC%B6%9C-%EB%B0%A9%EC%8B%9D)
- [서버 분리](https://github.com/xodhksrjqnr/toyProject-suitable_benefit/wiki/%EC%84%9C%EB%B2%84-%EB%B6%84%EB%A6%AC)
