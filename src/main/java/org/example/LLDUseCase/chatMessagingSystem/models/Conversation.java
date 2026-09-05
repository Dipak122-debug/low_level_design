package org.example.LLDUseCase.chatMessagingSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private final String conversationId;
    List<Message> messages = new ArrayList<>();
    List<User>participants = new ArrayList<>();

    public Conversation(String id) {
        this.conversationId = id;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public void addParticipant(User user){
        participants.add(user);
    }

    public String getConversationId() {
        return conversationId;
    }

    public List<User> getParticipants() {
        return participants;
    }

}
