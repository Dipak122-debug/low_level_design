package org.example.notificationManager;

import java.util.*;

/**
 * Notification manager responsible for registering channels and dispatching notifications.
 * Implements a lightweight Observer-like registry and supports sending to all channels or
 * to specific channel types.
 */
public class NotificationManager {

    private static NotificationManager instance;

    private final Map<NotificationType, List<NotificationChannel>> channels = new EnumMap<>(NotificationType.class);

    private NotificationManager() {
        // initialize lists for every type
        for (NotificationType t : NotificationType.values()) {
            channels.put(t, new ArrayList<>());
        }
    }

    public static synchronized NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    public void registerChannel(NotificationChannel channel) {
        channels.get(channel.getType()).add(channel);
    }

    public void unregisterChannel(NotificationChannel channel) {
        channels.get(channel.getType()).remove(channel);
    }

    /**
     * Send a notification to all registered channels.
     */
    public void notifyAllChannels(String message, String recipient) {
        for (List<NotificationChannel> list : channels.values()) {
            for (NotificationChannel ch : list) {
                ch.sendNotification(message, recipient);
            }
        }
    }

    /**
     * Send a notification only to channels of the specified type.
     */
    public void notifyByType(NotificationType type, String message, String recipient) {
        for (NotificationChannel ch : channels.get(type)) {
            ch.sendNotification(message, recipient);
        }
    }

    // Demo
    public static void main(String[] args) {
        NotificationManager manager = NotificationManager.getInstance();
        manager.registerChannel(new EmailNotification());
        manager.registerChannel(new SMSNotification());
        manager.registerChannel(new PushNotification());

        System.out.println("-- Notify all channels --");
        manager.notifyAllChannels("Hello, this is a test notification!", "JohnDoe@example.com");

        System.out.println("\n-- Notify only EMAIL channels --");
        manager.notifyByType(NotificationType.EMAIL, "Email specific message", "john@example.com");
    }
}

