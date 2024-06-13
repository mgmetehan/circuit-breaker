package com.mgmetehan.circuitbreaker.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class OrderService {

    @CircuitBreaker(name = "orderProcess", fallbackMethod = "fallback")
    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
    public void orderProcess(String orderDetails) throws Exception {
        int error = ThreadLocalRandom.current().nextInt(0, 10);
        //error = 9;
        if (error < 7) {
            log.info("Success");
        } else if (error == 7) {
            throw new RuntimeException("BusinessException");
        } else if (error == 8) {
            throw new RuntimeException("ValidationException");
        } else {
            throw new RuntimeException("Connect to db is failed");
        }
    }

    public String fallback(Throwable t) {
        return "Fallback response: " + t.getMessage();
    }
}
