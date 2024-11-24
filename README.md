# 레포지토리 설명
해당 리포지토리는 [해당 아티클의 실습](https://imksh.com/129)을 돕기 위한 레포지토리입니다.

# Docker Compose 실행
```bash
docker-compose up -d
```
- MySQL이 실행됩니다.
- MySQL 컨테이너는 schema.sql 파일을 이용해 초기 데이터베이스 스키마와 데이터를 자동으로 생성합니다.

# Gradle 빌드 및 Spring Boot 애플리케이션 실행
```bash
./gradlew bootRun
```
또는 IDE에서 Application 클래스를 실행합니다.

# API 엔드포인트
`resources/request.http` 파일을 참고해 주세요

## 1. 상품 검색 요청
```
[GET] /search
```
특정 카테고리의 상품 수를 검색합니다.
예시 요청:
```bash
curl "http://localhost:8080/search?category=shoes"
```
응답:
```
5 products found.
```

## 2. QPS 확인
```
[GET] /qps
```
서버가 초당 얼마나 많은 요청을 처리했는지 반환합니다.
```bash
curl "http://localhost:8080/qps"
```
응답:
```
QPS: 0.43, 측정한 시간(초): 7.00
```
테스트 방법
MySQL 데이터 확인
컨테이너 내부에서 MySQL에 접속해 데이터를 확인합니다:

```bash
docker exec -it mysql-container mysql -u root -prootpassword
```
MySQL 내부 명령:
```sql
USE shop;
SELECT * FROM products;
```
