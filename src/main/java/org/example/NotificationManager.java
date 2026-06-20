package org.example;

import java.util.ArrayList;
import java.util.List;

interface Notification{
    void sendNotification(String message, String recipient);
}

class EmailNotification implements Notification{

    @Override
    public void sendNotification(String message, String recipient){
        System.out.println("Sending email to " + recipient + " with message: " + message);
    }
}

class SMSNotification implements Notification{

    @Override
    public void sendNotification(String message, String recipient){
        System.out.println("Sending SMS to " + recipient + " with message: " + message);
    }
}

class PushNotification implements Notification{

    @Override
    public void sendNotification(String message, String recipient){
        System.out.println("Sending push notification to " + recipient + " with message: " + message);
    }
}


public class NotificationManager {

    List<Notification> notifcationsChannels = new ArrayList<>();

    public void addChannel(Notification notification){
        notifcationsChannels.add(notification);
    }

    public void notifyAll(String message, String recipient){
        for(Notification notification : notifcationsChannels){
            notification.sendNotification(message, recipient);
        }
    }


    public static void main(String[] args) {

        NotificationManager manager = new NotificationManager();
        manager.addChannel(new EmailNotification());
        manager.addChannel(new SMSNotification());
        manager.addChannel(new PushNotification());

        manager.notifyAll("Hello, this is a test notification!", "JohnDoe@example.com");

    }
}