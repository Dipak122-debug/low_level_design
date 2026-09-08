package org.example.LLDUseCase.ratelimiter.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Token Bucket Rate Limiter implementation.
 * This strategy allows a certain number of requests (tokens) in a given time frame.
 * Tokens are refilled at a specified rate, and if the bucket is full, excess tokens are discarded.
 */

public class TokenBucketRateLimiter implements RateLimiterStrategy{

    private final int maxCapacity;
    private final double refillRate; // tokens per second

    private final Map<String,Integer> userTokens = new ConcurrentHashMap<>();
    private final Map<String,Long> userLastRefillTime = new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int maxCapacity, double refillRate) {
        this.maxCapacity = maxCapacity;
        this.refillRate = refillRate;
    }

    @Override
    public synchronized boolean allowRequest(String userId) {

        long currentTime = System.currentTimeMillis();
        // Initialize user data if not present
        userLastRefillTime.putIfAbsent(userId, currentTime);
        userTokens.putIfAbsent(userId, maxCapacity);

        long lastRefillTime = userLastRefillTime.get(userId);

        long elapsedTime = (currentTime - lastRefillTime)/1000; // convert to seconds

        // Refill tokens based on elapsed time and refill rate
        if(elapsedTime > 0){
            int noOfTokenToAdd =  (int)(elapsedTime*refillRate);
            userTokens.put(userId, Math.min(maxCapacity, userTokens.get(userId) + noOfTokenToAdd));
            userLastRefillTime.put(userId, currentTime);
        }
        // if there are tokens available, allow the request and decrement the token count
        if(userTokens.get(userId) > 0){
            userTokens.put(userId, userTokens.get(userId) - 1);
            return true;
        }

        return false;
    }
}
