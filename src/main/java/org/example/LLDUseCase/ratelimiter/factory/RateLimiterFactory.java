package org.example.LLDUseCase.ratelimiter.factory;

import org.example.LLDUseCase.ratelimiter.strategy.FixedWindowRateLimiter;
import org.example.LLDUseCase.ratelimiter.strategy.RateLimiterStrategy;
import org.example.LLDUseCase.ratelimiter.strategy.SlidingWindowRateLimiter;

public class RateLimiterFactory {

    public static RateLimiterStrategy createRateLimiter(String type,int maxRequests, long windowSizeInMillis) {
        switch (type.toLowerCase()) {
            case "fixedwindow":
                return new FixedWindowRateLimiter(maxRequests, windowSizeInMillis);
            case "slidingwindow":
                return new SlidingWindowRateLimiter(maxRequests, windowSizeInMillis);

            default:
                throw new IllegalArgumentException("Unknown rate limiter type: " + type);
        }
    }
}
