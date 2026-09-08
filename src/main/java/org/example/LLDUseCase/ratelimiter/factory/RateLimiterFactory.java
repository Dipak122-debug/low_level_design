package org.example.LLDUseCase.ratelimiter.factory;

import org.example.LLDUseCase.ratelimiter.strategy.FixedWindowRateLimiter;
import org.example.LLDUseCase.ratelimiter.strategy.LeakyBucketRateLimiter;
import org.example.LLDUseCase.ratelimiter.strategy.RateLimiterStrategy;
import org.example.LLDUseCase.ratelimiter.strategy.SlidingWindowRateLimiter;
import org.example.LLDUseCase.ratelimiter.strategy.TokenBucketRateLimiter;

public class RateLimiterFactory {

    public static RateLimiterStrategy createRateLimiter(String type,int maxRequests, long windowSizeInMillis) {
        switch (type.toLowerCase()) {
            case "fixedwindow":
                return new FixedWindowRateLimiter(maxRequests, windowSizeInMillis);
            case "slidingwindow":
                return new SlidingWindowRateLimiter(maxRequests, windowSizeInMillis);
            case "tokenbucket":
                return new TokenBucketRateLimiter(maxRequests, windowSizeInMillis);
            case "leakybucket":
                return new LeakyBucketRateLimiter(maxRequests, windowSizeInMillis); // Assuming you have a LeakBucketRateLimiter class

            default:
                throw new IllegalArgumentException("Unknown rate limiter type: " + type);
        }
    }
}
