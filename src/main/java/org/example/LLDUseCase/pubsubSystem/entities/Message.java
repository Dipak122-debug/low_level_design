package org.example.LLDUseCase.pubsubSystem.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    private final String id;
    private final String payLoad;
    private final LocalDateTime timestamp;

    public Message(String payLoad) {
        this.payLoad = payLoad;
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
