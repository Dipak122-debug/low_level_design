package org.example.pubsubSystem.subcribers;

import org.example.pubsubSystem.entities.Message;

public interface Subscriber {
    void receiveMessage(Message message);

}
