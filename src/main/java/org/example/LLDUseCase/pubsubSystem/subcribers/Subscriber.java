package org.example.LLDUseCase.pubsubSystem.subcribers;

import org.example.LLDUseCase.pubsubSystem.entities.Message;

public interface Subscriber {
    void receiveMessage(Message message);

}
