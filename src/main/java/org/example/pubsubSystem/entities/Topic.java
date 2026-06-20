package org.example.pubsubSystem.entities;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.example.pubsubSystem.subcribers.Subscriber;

public class Topic {
    private String name;
    List<Subscriber> subscribers =new CopyOnWriteArrayList<>();

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}
