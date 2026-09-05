package org.example.LLDUseCase.splitwise.models;

public class Split {
    private String id;
    private User user;
    private double amount;
    private Double percentage; // optional, for percentage split

    public Split(String id, User user, double amount) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.percentage = null;
    }

    public Split(String id, User user, double amount, double percentage) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.percentage = percentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Split{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", amount=" + amount +
                ", percentage=" + percentage +
                '}';
    }
}

