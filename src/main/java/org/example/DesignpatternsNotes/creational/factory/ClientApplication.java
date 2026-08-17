package org.example.DesignpatternsNotes.creational.factory;

import org.example.DesignpatternsNotes.creational.factory.interfaces.Notification;
import org.example.DesignpatternsNotes.creational.factory.models.NotificationFactory;

public class ClientApplication {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        // Client asks for specific types without using the 'new' keyword on concrete classes
        Notification email = factory.createNotification("EMAIL");
        email.send("Hello via Email!");

        Notification sms = factory.createNotification("SMS");
        sms.send("Hello via SMS!");
    }
}
