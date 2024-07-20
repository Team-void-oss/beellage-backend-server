# Issue Tracker Backend

## 프로젝트 설명

이 프로젝트는 이슈와 일정을 관리할 수 있는 백엔드 API를 제공하는 Spring Boot 애플리케이션입니다. 이슈 생성, 수정, 삭제와 일정 생성, 수정, 삭제, 조회 기능을 제공합니다.

## 기술 스택

- Java 17
- Spring Boot 2.5.4
- Spring Data JPA
- PostgreSQL
- Docker

## 구조

```angular2html
issue-tracker/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── oss/
│   │   │   │           └── beellage/
│   │   │   │               ├── controller/
│   │   │   │               │   ├── IssueController.java
│   │   │   │               │   ├── ScheduleController.java
│   │   │   │               ├── service/
│   │   │   │               │   ├── IssueService.java
│   │   │   │               │   ├── ScheduleService.java
│   │   │   │               ├── repository/
│   │   │   │               │   ├── IssueRepository.java
│   │   │   │               │   ├── ScheduleRepository.java
│   │   │   │               ├── exception/
│   │   │   │               │   ├── ResourceNotFoundException.java
│   │   │   │               ├── dto/
│   │   │   │               │   ├── IssueRequest.java
│   │   │   │               │   ├── ScheduleRequest.java
│   │   │   │               ├── collection/
│   │   │   │               │   ├── IssueCollection.java
│   │   │   │               │   ├── ScheduleCollection.java
│   │   │   │               ├── constant/
│   │   │   │               │   ├── IssueStatus.java
│   │   │   │               ├── domain/
│   │   │   │               │   ├── Issue.java
│   │   │   │               │   ├── Schedule.java
│   │   │   │               │   ├── Project.java
│   │   │   │               │   ├── Team.java
│   │   │   ├── resources/
│   │   │   │   ├── application.properties
│   │   ├── test/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── oss/
│   │   │   │           └── beellage/
│   │   │   │               ├── BeellageApplicationTests.java
│   ├── build.gradle
│   ├── Dockerfile
│   ├── settings.gradle
```

## API 엔드포인트

| 기능          | 메서드    | URL                                                                 | 설명          | 요청 바디                                                                                  | 응답               |
|-------------|--------|---------------------------------------------------------------------|-------------|----------------------------------------------------------------------------------------|------------------|
| 이슈 생성       | POST   | `/api/v1/work/teams/{teamId}/projects/{projectId}/issues`           | 새로운 이슈 생성   | `{"title": "string", "description": "string", "assignedTo": long, "status": "string"}` | `201 Created`    |
| 이슈 수정       | PATCH  | `/api/v1/work/teams/{teamId}/projects/{projectId}/issues/{issueId}` | 이슈 수정       | `{"title": "string", "description": "string", "assignedTo": long, "status": "string"}` | `204 No Content` |
| 이슈 삭제       | DELETE | `/api/v1/work/teams/{teamId}/projects/{projectId}/issues/{issueId}` | 이슈 삭제       | N/A                                                                                    | `204 No Content` |
| 일정 생성       | POST   | `/api/v1/work/teams/{teamId}/schedules`                             | 새로운 일정 생성   | `{"title": "string", "date": "string", "projectId": long, "issueId": long}`            | `201 Created`    |
| 일정 수정       | PATCH  | `/api/v1/work/teams/{teamId}/schedules/{scheduleId}`                | 일정 수정       | `{"title": "string", "date": "string", "projectId": long, "issueId": long}`            | `204 No Content` |
| 일정 삭제       | DELETE | `/api/v1/work/teams/{teamId}/schedules/{scheduleId}`                | 일정 삭제       | N/A                                                                                    | `204 No Content` |
| 전체 일정 조회    | GET    | `/api/v1/work/teams/{teamId}/schedules`                             | 전체 일정 조회    | N/A                                                                                    | `200 OK`         |
| 프로젝트별 일정 조회 | GET    | `/api/v1/work/teams/{teamId}/schedules?projectId={}`                | 프로젝트별 일정 조회 | N/A                                                                                    | `200 OK`         |

## 실행 방법

1. 프로젝트 클론
    ```bash
    git clone https://github.com/judy-oss-team/beellage-backend-server.git
    git checkout -b feature/issue
    git pull origin feature/issue
    ```

2. Docker 컨테이너 실행
    ```bash
    docker-compose up --build
    ```

3. 애플리케이션에 접속
    - API 서버: `http://localhost:8080`

## 포트 설정

- API 서버: `8080`
- PostgreSQL: `5432`


