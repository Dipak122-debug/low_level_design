package org.example.chatMessagingSystem.services;

import org.example.chatMessagingSystem.enums.UserStatus;
import org.example.chatMessagingSystem.models.Message;
import org.example.chatMessagingSystem.models.User;

public class NotificationService {

    public void notifyUser(User receiver, Message message) {
        // Logic to send notification to the user
        if(receiver.getStatus()== UserStatus.ONLINE){
            receiver.receiveMessage(message);
        }
        else{
            System.out.println("User " + receiver.getUsername() + " is offline. Notification will be sent when they are online.");
        }
    }
}
