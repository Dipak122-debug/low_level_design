package org.example.ratelimiter.strategy;

public interface RateLimiterStrategy {

    boolean allowRequest(String userId);
}
