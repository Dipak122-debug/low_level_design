package org.example.ratelimiter.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.example.ratelimiter.factory.RateLimiterFactory;
import org.example.ratelimiter.strategy.RateLimiterStrategy;

public class RateLimiterService {

    private final Map<String, RateLimiterStrategy> userRateLimiters = new ConcurrentHashMap<>();

    public void registerUser(String userId, String rateLimiterStrategy, int maxRequests, long timeWindow) {
        userRateLimiters.put(userId, RateLimiterFactory.createRateLimiter(rateLimiterStrategy, maxRequests, timeWindow));
    }

    public boolean isRequestAllowed(String userId) {
        RateLimiterStrategy rateLimiter = userRateLimiters.get(userId);
        if (rateLimiter == null) {
            throw new IllegalArgumentException("User not registered: " + userId);
        }
        return rateLimiter.allowRequest(userId);
    }

}
