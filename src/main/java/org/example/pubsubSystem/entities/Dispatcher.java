package org.example.pubsubSystem.entities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.example.pubsubSystem.subcribers.Subscriber;

public class Dispatcher {
    private ExecutorService executorService;

    public Dispatcher() {
        this.executorService = Executors.newFixedThreadPool(5);
    }

    public void dispatch(Subscriber subscriber, Message message) {
        executorService.submit(() -> subscriber.receiveMessage(message));
    }

    public void shutDown() {
        executorService.shutdown();
    }
}

