package org.example.chatMessagingSystem.models;

import org.example.chatMessagingSystem.services.MessagingService;

public class ChatServer {

    private MessagingService messagingService = new MessagingService();

    public void sendMessage(User sender, Message message, Conversation conversation) {
        messagingService.send(sender, message, conversation);
    }

}
