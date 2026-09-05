package org.example.LLDUseCase.chatMessagingSystem.services;

import org.example.LLDUseCase.chatMessagingSystem.enums.UserStatus;
import org.example.LLDUseCase.chatMessagingSystem.models.Message;
import org.example.LLDUseCase.chatMessagingSystem.models.User;

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
