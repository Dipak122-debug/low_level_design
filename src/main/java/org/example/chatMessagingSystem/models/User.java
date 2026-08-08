package org.example.chatMessagingSystem.models;

import org.example.chatMessagingSystem.enums.UserStatus;

public class User {
    private String id;
    private String username;
    private UserStatus userStatus;

    public User(String id, String username, UserStatus userStatus) {
        this.id = id;
        this.username = username;
        this.userStatus = userStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserStatus getStatus() {
        return userStatus;
    }
    public  void setStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

   public void receiveMessage(Message message){
        System.out.println("User " + username + " received message: " + message.getContent());
    }
}
