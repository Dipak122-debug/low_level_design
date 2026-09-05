package org.example.LLDUseCase.ratelimiter.strategy;

public interface RateLimiterStrategy {

    boolean allowRequest(String userId);
}
