package org.example.pubsubSystem.subcribers;

import org.example.pubsubSystem.entities.Message;

public class LoggingSubscriber implements Subscriber {

    private String name;

    public LoggingSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println(Thread.currentThread().getName() + ": Logging Subscriber (" + name + ") received message: " + message.getPayLoad());
    }

}


