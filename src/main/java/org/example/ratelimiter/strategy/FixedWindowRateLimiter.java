package org.example.ratelimiter.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class FixedWindowRateLimiter implements RateLimiterStrategy{

    private final int maxRequests;
    private final long timeWindowMillis;
    private final Map<String,Integer> userRequestCounts = new ConcurrentHashMap<>();
    private  long windowStart;

    public FixedWindowRateLimiter(int maxRequests, long timeWindowMillis) {
        this.maxRequests = maxRequests;
        this.timeWindowMillis = timeWindowMillis;
        this.windowStart = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean allowRequest(String userId) {

        long currentTime = System.currentTimeMillis();
        if(currentTime - windowStart >= timeWindowMillis){
            userRequestCounts.clear();
            windowStart = currentTime;
        }

        userRequestCounts.put(userId, userRequestCounts.getOrDefault(userId, 0) + 1);

        if(userRequestCounts.get(userId) <= maxRequests){
            return true;
        }
        return false;
    }
}
