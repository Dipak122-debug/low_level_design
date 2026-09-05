package org.example.LLDUseCase.pubsubSystem.entities;

public class Publisher {
    private String name;
    private Broker broker;

    public Publisher(String name, Broker broker) {
        this.name = name;
        this.broker = broker;
    }

    public void publish(String topic, String payload){
        Message message = new Message(payload);
        System.out.println("Publisher " + name + " is publishing message: " + payload + " to topic: " + topic);
        broker.publish(topic, message);
    }
}
