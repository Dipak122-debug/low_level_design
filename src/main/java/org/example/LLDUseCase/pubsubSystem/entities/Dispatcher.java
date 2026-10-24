package org.example.LLDUseCase.pubsubSystem.entities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.example.LLDUseCase.pubsubSystem.subcribers.Subscriber;

public class Dispatcher {
    private ExecutorService executorService;

    // why fixed thread pool of 5? Because we want to limit the number of concurrent threads that can process messages. This helps to prevent resource exhaustion and ensures that the system remains responsive under load. A fixed thread pool allows us to control the number of threads and manage them efficiently.
    // why multithreading?
    // Because we want to allow multiple subscribers to receive messages concurrently.
    // This improves the overall throughput and responsiveness of the system, as subscribers can process messages in parallel without blocking each other.
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

