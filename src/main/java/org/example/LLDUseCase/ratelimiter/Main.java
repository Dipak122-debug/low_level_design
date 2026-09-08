package org.example.LLDUseCase.ratelimiter;

import org.example.LLDUseCase.ratelimiter.services.RateLimiterService;

public class Main {
    public static void main(String[] args) {
        RateLimiterService rateLimiter = new RateLimiterService();

        rateLimiter.registerUser("user1", "fixedWindow", 5, 1000); // 5 requests per second
        rateLimiter.registerUser("user2", "slidingWindow", 3, 500); // 10 requests per second
        rateLimiter.registerUser("user3", "tokenBucket", 4, 1000); // 4 requests per second
        rateLimiter.registerUser("user4", "leakyBucket", 2, 1000); // 2 requests per second
        for (int i = 0; i < 10; i++) {
            System.out.println("User1 request " + (i + 1) + ": " + rateLimiter.isRequestAllowed("user1"));
            System.out.println("User2 request " + (i + 1) + ": " + rateLimiter.isRequestAllowed("user2"));
            System.out.println("User3 request " + (i + 1) + ": " + rateLimiter.isRequestAllowed("user3"));
            System.out.println("User4 request " + (i + 1) + ": " + rateLimiter.isRequestAllowed("user4"));
        }
    }
}
