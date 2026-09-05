package org.example.designpatternsNotes.creational.factory.models;

import org.example.designpatternsNotes.creational.factory.interfaces.Notification;

public class NotificationFactory {
    // Factory method conditionally creates objects based on String input
    public Notification createNotification(String channel) {
        if (channel == null || channel.trim().isEmpty()) {
            throw new IllegalArgumentException("Channel type cannot be null or empty");
        }

        return switch (channel.toUpperCase()) {
            case "EMAIL" -> new EmailNotification();
            case "SMS"   -> new SmsNotification();
            case "PUSH"  -> new PushNotification();
            default      -> throw new IllegalArgumentException("Unknown notification channel: " + channel);
        };
    }
}