package org.example.billingSystem.models;

public class User {
    private String id;
    private String name;
    private String email;
    private Subscription subscription;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Subscription getSubscription() {
        return subscription;
    }
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
