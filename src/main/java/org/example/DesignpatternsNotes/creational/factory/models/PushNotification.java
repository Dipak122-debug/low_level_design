package org.example.DesignpatternsNotes.creational.factory.models;

import org.example.DesignpatternsNotes.creational.factory.interfaces.Notification;

public class PushNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}
