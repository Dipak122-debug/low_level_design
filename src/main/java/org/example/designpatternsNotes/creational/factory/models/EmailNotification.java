package org.example.designpatternsNotes.creational.factory.models;

import org.example.designpatternsNotes.creational.factory.interfaces.Notification;

public class EmailNotification implements Notification {

    @Override
    public void send(String message){
        System.out.println("Sending Email: " + message);
    }
}
