package org.example.pubsubSystem.entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.example.pubsubSystem.subcribers.Subscriber;

public class Broker {
    private Dispatcher dispatcher = new Dispatcher();
    private Map<String, Topic> topics = new ConcurrentHashMap<>();



    public void createTopic(String topicName){
        if(!topics.containsKey(topicName)){
            Topic topic = new Topic(topicName);
            topics.put(topicName, topic);
        }
    }

    public void subscribe(String topicName, Subscriber subscriber){
        if(topics.containsKey(topicName)){
            Topic topic = topics.get(topicName);
            topic.addSubscriber(subscriber);
        }
    }

    public void unsubscribe(String topicName, Subscriber subscriber){
        if(topics.containsKey(topicName)){
            Topic topic = topics.get(topicName);
            topic.removeSubscriber(subscriber);
        }
    }

    public void publish(String topicName, Message message){
        Topic topic = topics.get(topicName);
        if(null==topic){
            throw new RuntimeException("Topic not found");
        }

        for(Subscriber subscriber : topic.getSubscribers()){
            dispatcher.dispatch(subscriber, message);
        }

    }

    public void shutdown() {
        dispatcher.shutDown();
    }

}
