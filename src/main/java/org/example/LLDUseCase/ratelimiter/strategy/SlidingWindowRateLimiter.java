package org.example.LLDUseCase.ratelimiter.strategy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Sliding Window Rate Limiter implementation.
 * This strategy allows a maximum number of requests within a specified time window.
 * It maintains a deque of timestamps for each user and removes timestamps that fall outside the window.
 */

public class SlidingWindowRateLimiter implements RateLimiterStrategy{

    private final int maxRequests;
    private final long windowSizeInMillis;
    private final Map<String, Deque<Long>> userRequestTimestamps = new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    @Override
    public synchronized boolean allowRequest(String userId) {

        long currentTime = System.currentTimeMillis();
        Deque<Long> timestamps = userRequestTimestamps.computeIfAbsent(userId,
                k -> new LinkedList<>());

        timestamps.add(currentTime);

        while (!timestamps.isEmpty() && currentTime - timestamps.peekFirst() >= windowSizeInMillis) {
            timestamps.pollFirst();
        }
        return timestamps.size() <= maxRequests;
    }
}
