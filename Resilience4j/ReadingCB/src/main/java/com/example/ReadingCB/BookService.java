package com.example.ReadingCB;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.reactor.ratelimiter.operator.RateLimiterOperator;
import io.github.resilience4j.reactor.retry.RetryOperator;
import io.github.resilience4j.reactor.timelimiter.TimeLimiterOperator;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;



@Service
public class BookService {
    private static final Logger LOG = LoggerFactory.getLogger(BookService.class);


    private final WebClient webClient;
    private final TimeLimiter timeLimiter;
//    private final RateLimiter rateLimiter;
//    private final Retry retry;

//    private final ReactiveCircuitBreaker readingListCircuitBreaker;
//
//    public BookService(ReactiveCircuitBreakerFactory circuitBreakerFactory) {
//        this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
//        this.readingListCircuitBreaker = circuitBreakerFactory.create("recommended");
//    }

//    public Mono<String> readingList() {
//        return readingListCircuitBreaker.run(webClient.get().uri("/recommended").retrieve().bodyToMono(String.class), throwable -> {
//            LOG.warn("Error making request to book service", throwable);
//            return Mono.just("Error making request to book service");
//        });
//    }

//    public BookService(RetryRegistry retryRegistry) {
//        this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
//        this.retry = retryRegistry.retry("recommended");  // Tạo một retry instance từ retryRegistry
//    }
//
//    public Mono<String> readingList() {
//        return webClient.get()
//                .uri("/recommended")
//                .retrieve()
//                .bodyToMono(String.class)
//                .transformDeferred(RetryOperator.of(retry))  // Áp dụng retry
//                .onErrorResume(throwable -> {
//                    LOG.warn("Error making request to book service", throwable);
//                    return Mono.just("Error making request to book service");  // Fallback nếu có lỗi
//                });
//    }
//public BookService(RateLimiterRegistry rateLimiterRegistry) {
//    this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
//    this.rateLimiter = rateLimiterRegistry.rateLimiter("recommended");
//}
//
//    public Mono<String> readingList() {
//        return webClient.get()
//                .uri("/recommended")
//                .retrieve()
//                .bodyToMono(String.class)
//                .transformDeferred(RateLimiterOperator.of(rateLimiter))
//                .onErrorResume(throwable -> {
//                    return Mono.just("Rate limit reached!");
//                });
//    }
public BookService(TimeLimiterRegistry timeLimiterRegistry) {
    this.webClient = WebClient.builder().baseUrl("http://localhost:8090").build();
    this.timeLimiter = timeLimiterRegistry.timeLimiter("recommended");
}

    public Mono<String> readingList() {
        return webClient.get()
                .uri("/recommended")
                .retrieve()
                .bodyToMono(String.class)
                .transformDeferred(TimeLimiterOperator.of(timeLimiter))
                .onErrorResume(throwable -> {
                    return Mono.just("Timeout! Service took too long.");
                });
    }
}
