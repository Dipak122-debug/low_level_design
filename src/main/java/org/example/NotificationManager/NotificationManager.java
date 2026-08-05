package org.example.NotificationManager;

import java.util.ArrayList;
import java.util.List;


public class NotificationManager {

    List<Notification> notifcationsChannels = new ArrayList<>();

    public void addChannel(Notification notification) {
        notifcationsChannels.add(notification);
    }

    public void notifyAll(String message, String recipient) {
        for (Notification notification : notifcationsChannels) {
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

