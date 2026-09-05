package org.example.ratelimiter.factory;

import org.example.ratelimiter.strategy.RateLimiterStrategy;

public class RateLimiterFactory {

    public static RateLimiterStrategy createRateLimiter(String type,int maxRequests, long windowSizeInMillis) {
        switch (type.toLowerCase()) {
            case "fixedwindow":
                return new org.example.ratelimiter.strategy.FixedWindowRateLimiter(maxRequests, windowSizeInMillis);
            case "slidingwindow":
                return new org.example.ratelimiter.strategy.SlidingWindowRateLimiter(maxRequests, windowSizeInMillis);

            default:
                throw new IllegalArgumentException("Unknown rate limiter type: " + type);
        }
    }
}
