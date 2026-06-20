package org.example.pubsubSystem.subcribers;

import org.example.pubsubSystem.entities.Message;

public class PrintSubscriber implements Subscriber{

    private String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void receiveMessage(Message message) {
        System.out.println(Thread.currentThread().getName() + ": Print Subscriber (" + name + ") received message: " + message.getPayLoad());
    }
}
