package org.example.LLDUseCase.chatMessagingSystem.models;

import java.time.LocalDateTime;
import org.example.LLDUseCase.chatMessagingSystem.enums.MessageStatus;
import org.example.LLDUseCase.chatMessagingSystem.enums.MessageType;

public class Message {

    private String id;
    private User sender;
    private String conversationId;
    private String content;
    private LocalDateTime timestamp;
    private MessageType messageType;
    private MessageStatus status;

    public Message(String id, User sender, String conversationId, String content, LocalDateTime timestamp, MessageType messageType) {
        this.id = id;
        this.sender = sender;
        this.conversationId = conversationId;
        this.content = content;
        this.timestamp = timestamp;
        this.messageType = messageType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }
}
