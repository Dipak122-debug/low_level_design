package org.example.chatMessagingSystem.services;

import org.example.chatMessagingSystem.models.Conversation;
import org.example.chatMessagingSystem.models.Message;
import org.example.chatMessagingSystem.models.User;

public class MessagingService {

    private NotificationService notificationService = new NotificationService();

    // why conversation is passed as parameter? because we need to know which conversation the message belongs to, so that we can add the message to the conversation and notify the participants of that conversation.
    public void send(User sender, Message message, Conversation conversation) {
        conversation.addMessage(message);
        for (User participant : conversation.getParticipants()) {
            if (!participant.getId().equals(sender.getId())) {
                //participant.receiveMessage(message);
                notificationService.notifyUser(participant, message);
            }
        }
    }
}
