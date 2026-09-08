package org.example.LLDUseCase.ratelimiter.strategy;

import java.util.LinkedList;
import java.util.Queue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Leaky Bucket Rate Limiter implementation.
 * This rate limiter allows a maximum number of requests to be processed in a given time frame.
 * Requests that exceed the limit are rejected until the bucket leaks (processes) requests at a fixed rate.
 */

public class LeakyBucketRateLimiter implements RateLimiterStrategy{


    private final int maxCapacity;
    private final long leakRateSec; // if it is 2 then every 2 seconds, one request leaks out (gets processed).
    private final Queue<Long> bucket = new LinkedList<>();
    private final ScheduledExecutorService executorService;

    public LeakyBucketRateLimiter(int maxCapacity, long leakRateSec) {
        this.maxCapacity = maxCapacity;
        this.leakRateSec = leakRateSec;
        executorService = Executors.newScheduledThreadPool(1);
        // Schedule the leakRequest method to run at a fixed rate
        executorService.scheduleAtFixedRate(this::leakRequest, 0, leakRateSec, TimeUnit.SECONDS);

    }



    @Override
    public synchronized boolean allowRequest(String userId) {
        if (bucket.size() >= maxCapacity) {
            return false; // Bucket is full, reject the request
        }
        bucket.offer(System.currentTimeMillis()); // Add the request to the bucket
        return true;
    }

    // Leak the oldest request from the bucket at a fixed rate
    public synchronized void leakRequest() {
        if (!bucket.isEmpty()) {
            bucket.poll(); // Remove the oldest request from the bucket
        }
    }
}
