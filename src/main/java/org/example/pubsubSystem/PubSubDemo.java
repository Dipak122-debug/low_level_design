package org.example.pubsubSystem;

import org.example.pubsubSystem.entities.Broker;
import org.example.pubsubSystem.entities.Publisher;
import org.example.pubsubSystem.subcribers.LoggingSubscriber;
import org.example.pubsubSystem.subcribers.PrintSubscriber;
import org.example.pubsubSystem.subcribers.Subscriber;

public class PubSubDemo {
    public static void main(String[] args){

        Broker broker = new Broker();

        Subscriber subscriber1 = new PrintSubscriber("Dipak");
        Subscriber subscriber2 = new LoggingSubscriber("logger1");
        Subscriber subscriber3 = new PrintSubscriber("Alice");

        broker.createTopic("news");
        broker.createTopic("sports");

        broker.subscribe("news", subscriber2);
        broker.subscribe("sports", subscriber1);
        broker.subscribe("sports", subscriber3);

        Publisher publisher = new Publisher("publisher1", broker);
        publisher.publish("news", "Breaking news!");
        publisher.publish("sports", "Team wins the match!");

    }
}
