package org.example.designpatternsNotes.creational.factory.models;

import org.example.designpatternsNotes.creational.factory.interfaces.Notification;

public class SmsNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
