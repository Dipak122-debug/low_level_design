package org.example.splitwise.models;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private String id;
    private User user;
    private Map<User, Double> balances; // Map of User to amount (positive means user is owed, negative means user owes)

    public BalanceSheet(String id, User user) {
        this.id = id;
        this.user = user;
        this.balances = new HashMap<>();
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

    public void addBalance(User user, double amount) {

        balances.put(user, balances.getOrDefault(user, 0.0) + amount);
    }

    public double getBalance(User user) {
        return balances.getOrDefault(user, 0.0);
    }

    public void setBalance(User user, double amount) {

        balances.put(user, amount);
    }

    // It returns a copy of the balances map to prevent external modification
    public Map<User, Double> showBalances() {
        return new HashMap<>(balances);
    }

    public double showBalanceWithUser(User user) {
        return balances.getOrDefault(user, 0.0);
    }

    @Override
    public String toString() {
        return "BalanceSheet{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", balances=" + balances +
                '}';
    }
}

