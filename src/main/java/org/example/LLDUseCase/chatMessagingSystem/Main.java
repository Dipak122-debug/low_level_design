package org.example.LLDUseCase.chatMessagingSystem;

import java.time.LocalDateTime;
import org.example.LLDUseCase.chatMessagingSystem.enums.MessageType;
import org.example.LLDUseCase.chatMessagingSystem.enums.UserStatus;
import org.example.LLDUseCase.chatMessagingSystem.models.ChatServer;
import org.example.LLDUseCase.chatMessagingSystem.models.Conversation;
import org.example.LLDUseCase.chatMessagingSystem.models.Message;
import org.example.LLDUseCase.chatMessagingSystem.models.User;

public class Main {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User Dipak = new User("1", "Dipak", UserStatus.ONLINE);
        User Sarmistha = new User("2", "Sarmistha", UserStatus.ONLINE);

        Conversation conversation = new Conversation("A1");
        conversation.addParticipant(Dipak);
        conversation.addParticipant(Sarmistha);

        Message message = new Message("1",  Dipak, "A1",
                "Hello Sarmistha!", LocalDateTime.now() , MessageType.TEXT);
        chatServer.sendMessage(Dipak,message,conversation);
    }
}
