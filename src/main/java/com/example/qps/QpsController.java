package com.example.qps;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequiredArgsConstructor
public class QpsController {

    private final JdbcTemplate jdbcTemplate;
    private final AtomicInteger queryCount = new AtomicInteger(0);
    private long startTime = System.currentTimeMillis();

    // 상품 검색 요청 처리
    @GetMapping("/search")
    public String search(String category) {
        queryCount.incrementAndGet(); // 쿼리 카운트 증가
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM products WHERE category = ?",
                new Object[]{category},
                Integer.class
        ) + " products found.";
    }

    // QPS 측정
    @GetMapping("/qps")
    public String getQps() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        if(elapsedTime > 1000) {
            double qps = queryCount.get() / (elapsedTime / 1000.0); // 평균 QPS 계산
            queryCount.set(0); // 카운터 초기화
            startTime = currentTime;
            return String.format("QPS: %.2f, 측정한 시간(초): %.2f", qps, elapsedTime / 1000.0);
        }
        return "요청 간격은 1초를 넘어야 합니다.";
    }
}
