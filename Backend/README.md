# [BE] issue-tracker

Github 의 issue 기능과 유사한 서비스를 구현하는것이 목표입니다.

- 소셜 로그인
- 이슈
  - 등록
  - 목록 조회 / 필터링 조회
  - 수정 / 다중선택 수정
  - 상세 조회
- 댓글 기능(등록/수정/삭제/조회)
- 레이블 관리
- 마일스톤 관리
    
## 1. 인프라 구조

![](https://camo.githubusercontent.com/c21b4d11b9c3c826b90657c7357ed67ec1aa2e72999e1c96117234d503125cbb/68747470733a2f2f626c6f672e6b616b616f63646e2e6e65742f646e2f6347504736722f6274724535797865374d782f364b566e6841594858584b4e3178584e4946535149302f696d672e706e67)
그림-1

### 1.1 FE 배포 과정

1. Github Action 에서 Webpack 빌드로 html 생성
2. S3 에 업로드
3. CloudFront 캐시 리프레시

### 1.2 BE 배포 과정

1. Github Action 에서 jar 빌드
2. S3 에 업로드
3. CodeDeploy 배포 실행
4. EC2 에서 jar 실행
